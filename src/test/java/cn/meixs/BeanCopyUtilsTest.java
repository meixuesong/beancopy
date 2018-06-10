package cn.meixs;

import cn.meixs.beancopy.domain.Address;
import cn.meixs.beancopy.domain.Customer;
import cn.meixs.beancopy.domain.Order;
import cn.meixs.beancopy.domain.OrderItem;
import cn.meixs.beancopy.domain.OrderStatus;
import cn.meixs.beancopy.domain.Phone;
import cn.meixs.cn.beancopy.repository.OrderJpa;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BeanCopyUtilsTest {

    public static final String PRODUCT_ID = "234523429802934";
    public static final String ORDER_ID = "111111111";
    public static final String CITY = "BEIJING";
    public static final String CUSTOMER_NAME = "SOMEBODY";
    public static final String PHONE_NO = "8888888888";
    public static final int PERFORMANCE_TEST_TIMES = 100000;
    public static final String DATE = "2018-01-02";
    private static long Benchmark_Elapsed_Time;

    @Before
    public void setUp() throws Exception {
        initNativeSetterTime();
    }

    @Test
    public void should_copy_order_by_hardcode_setter() throws Exception {
        //Given
        OrderMapper mapper = new OrderMapperSetterImpl();
        Date createDate = Date.valueOf(DATE);
        Order order = createOrder(createDate);

        //When
        OrderJpa orderCopied = mapper.fromOrder(order);

        //Then
        checkResult(createDate, orderCopied);
    }

    @Test
    public void should_copy_order_by_spring_beanutils() throws Exception {
        //Given
        OrderMapper mapper = new OrderMapperSpringBeanUtilsImpl();
        Date createDate = Date.valueOf(DATE);
        Order order = createOrder(createDate);

        //When
        OrderJpa orderCopied = mapper.fromOrder(order);

        //Then
        checkResult(createDate, orderCopied);

        //And Performance test.
        //Slow than twice benchmark time. so it is commented.
//        performanceTest(order, mapper, Benchmark_Elapsed_Time * 2);
    }

    @Test
    public void should_copy_order_by_cglib() throws Exception {
        //Given
        OrderMapper mapper = new OrderMapperCglibImpl();
        Date createDate = Date.valueOf(DATE);
        Order order = createOrder(createDate);

        //When
        OrderJpa orderCopied = mapper.fromOrder(order);

        //Then
        checkResult(createDate, orderCopied);

        //And Performance test
        performanceTest(order, mapper, Benchmark_Elapsed_Time * 2);
    }

    private void performanceTest(Order order, OrderMapper mapper, long maxAllowedTime) {
        //Warm up
        for (int i = 0; i < 10000; i++) {
            List<OrderJpa> results = new ArrayList<>();
            results.add(mapper.fromOrder(order));
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            List<OrderJpa> results = new ArrayList<>();
            results.add(mapper.fromOrder(order));
        }
        long end = System.currentTimeMillis();
        System.out.println("using: " + (end - start) + "ms.");

        assertThat(end - start).isLessThan(maxAllowedTime);
    }

    private void checkResult(Date createDate, OrderJpa orderCopied) {
        assertTrue(orderCopied.getOrderId().startsWith(ORDER_ID));
        assertEquals(createDate, orderCopied.getCreateDate());
        assertThat(orderCopied.getCustomer()).isNotNull();
        assertEquals(CITY, orderCopied.getCustomer().getHomeAddress().getCity());
        assertEquals(CUSTOMER_NAME, orderCopied.getCustomer().getName());
        assertEquals(PHONE_NO, orderCopied.getPhone().getPhoneNo());
        assertEquals(orderCopied.getCity(), CITY);
        assertThat(orderCopied.getItems()).hasSize(10);
        assertThat(orderCopied.getItems().get(0).getProductId()).isEqualTo(PRODUCT_ID);
    }

    private void initNativeSetterTime() throws Exception {
        if (Benchmark_Elapsed_Time == 0) {
            Order order = createOrder(Date.valueOf("2018-01-01"));
            OrderMapper mapper = new OrderMapperSetterImpl();

            //warm up
            for (int i = 0; i < 10000; i++) {
                List<OrderJpa> results = new ArrayList<>();
                results.add(mapper.fromOrder(order));
            }

            long start = System.currentTimeMillis();
            for (int i = 0; i < PERFORMANCE_TEST_TIMES; i++) {
                List<OrderJpa> results = new ArrayList<>();
                results.add(mapper.fromOrder(order));
            }
            long end = System.currentTimeMillis();

            Benchmark_Elapsed_Time = end - start;
            System.out.println("standard (using harder code setter) time: " + Benchmark_Elapsed_Time + "ms");
        }
    }

    private Order createOrder(Date createDate) {
        Customer customer = new Customer("1111", CUSTOMER_NAME,
                new Address("BEIJING", CITY, "东直门"),
                new Phone("88888888888"));

        Address deliverAddress = new Address(CITY, "BEIJING", "东直门");
        Phone phone = new Phone(PHONE_NO);

        ArrayList<OrderItem> items = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            OrderItem item = new OrderItem(PRODUCT_ID, new BigDecimal(10.0), new BigDecimal(100.0), "");
            items.add(item);
        }

        return new Order(ORDER_ID, customer,
                deliverAddress,
                phone,
                new BigDecimal(123.01),
                OrderStatus.CREATED,
                createDate,
                Date.valueOf(DATE),
                null,
                items);
    }
}