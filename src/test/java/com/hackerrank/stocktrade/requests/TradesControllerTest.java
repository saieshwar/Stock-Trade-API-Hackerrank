package com.hackerrank.stocktrade.requests;

import com.hackerrank.test.utility.Order;
import com.hackerrank.test.utility.OrderedTestRunner;
import com.hackerrank.test.utility.ResultMatcher;
import com.hackerrank.test.utility.TestWatchman;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(OrderedTestRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TradesControllerTest {

    @ClassRule
    public static final SpringClassRule springClassRule = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();
    
    @Rule
    public TestWatcher watchman = TestWatchman.watchman;
    
    @Autowired
    private MockMvc mockMvc;

    @BeforeClass
    public static void setUpClass() {
        TestWatchman.watchman.registerClass(TradesControllerTest.class);
    }

    @AfterClass
    public static void tearDownClass() {
        TestWatchman.watchman.createReport(TradesControllerTest.class);
    }

    /**
     *
     * @throws Exception
     *
     * It tests creating trade
     */
    @Test
    @Order(1)
    public void createTrade() throws Exception {
        /**
         *
         * Create trade with id 1
         *
         * The request body is:
         * {
         *     "id": 1,
         *     "type": "buy",
         *     "user": {
         *         "id": 2,
         *         "name": "Amy Palmer"
         *     },
         *     "symbol": "AA",
         *     "shares": 11,
         *     "price": 174.82,
         *     "timestamp": "2018-12-28 13:18:48"
         * }
         */
        String json = "{\"id\": 1, \"type\": \"buy\", \"user\": {\"id\": 2, \"name\": \"Amy Palmer\"}, \"symbol\": \"AA\", \"shares\": 11, \"price\": 174.82, \"timestamp\": \"2018-12-28 13:18:48\"}";

        mockMvc.perform(
                post("/trades")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create trade with id 2
         *
         * The request body is:
         * {
         *     "id": 2,
         *     "type": "buy",
         *     "user": {
         *         "id": 2,
         *         "name": "Amy Palmer"
         *     },
         *     "symbol": "AA",
         *     "shares": 11,
         *     "price": 174.82,
         *     "timestamp": "2018-12-29 09:47:43"
         * }
         */
        json = "{\"id\": 2, \"type\": \"buy\", \"user\": {\"id\": 2, \"name\": \"Amy Palmer\"}, \"symbol\": \"AA\", \"shares\": 11, \"price\": 174.82, \"timestamp\": \"2018-12-29 09:47:43\"}";

        mockMvc.perform(
                post("/trades")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create trade with id 3
         *
         * The request body is:
         * {
         *     "id": 3,
         *     "type": "buy",
         *     "user": {
         *         "id": 1,
         *         "name": "Briana Ortiz"
         *     },
         *     "symbol": "A",
         *     "shares": 20,
         *     "price": 155.32,
         *     "timestamp": "2019-01-01 11:19:01"
         * }
         */
       json = "{\"id\": 3, \"type\": \"buy\", \"user\": {\"id\": 1, \"name\": \"Briana Ortiz\"}, \"symbol\": \"A\", \"shares\": 20, \"price\": 155.32, \"timestamp\": \"2019-01-01 11:19:01\"}";

       mockMvc.perform(
                post("/trades")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create trade with id 4
         *
         * The request body is:
         * {
         *     "id": 4,
         *     "type": "buy",
         *     "user": {
         *         "id": 2,
         *         "name": "Amy Palmer"
         *     },
         *     "symbol": "AA",
         *     "shares": 11,
         *     "price": 174.82,
         *     "timestamp": "2019-01-01 12:02:03"
         * }
         */
        json = "{\"id\": 4, \"type\": \"buy\", \"user\": {\"id\": 2, \"name\": \"Amy Palmer\"}, \"symbol\": \"AA\", \"shares\": 11, \"price\": 174.82, \"timestamp\": \"2019-01-01 12:02:03\"}";

        mockMvc.perform(
                post("/trades")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create trade with id 5
         *
         * The request body is:
         * {
         *     "id": 5,
         *     "type": "buy",
         *     "user": {
         *         "id": 1,
         *         "name": "Briana Ortiz"
         *     },
         *     "symbol": "AA",
         *     "shares": 11,
         *     "price": 174.82,
         *     "timestamp": "2019-01-02 15:31:49"
         * }
         */
        json = "{\"id\": 5, \"type\": \"buy\", \"user\": {\"id\": 1, \"name\": \"Briana Ortiz\"}, \"symbol\": \"AA\", \"shares\": 11, \"price\": 174.82, \"timestamp\": \"2019-01-02 15:31:49\"}";

        mockMvc.perform(
                post("/trades")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create trade with id 6
         *
         * The request body is:
         * {
         *     "id": 6,
         *     "type": "buy",
         *     "user": {
         *         "id": 1,
         *         "name": "Briana Ortiz"
         *     },
         *     "symbol": "A",
         *     "shares": 20,
         *     "price": 155.32,
         *     "timestamp": "2019-01-02 15:42:18"
         * }
         */
        json = "{\"id\": 6, \"type\": \"buy\", \"user\": {\"id\": 1, \"name\": \"Briana Ortiz\"}, \"symbol\": \"A\", \"shares\": 20, \"price\": 155.32, \"timestamp\": \"2019-01-02 15:42:18\"}";

        mockMvc.perform(
                post("/trades")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());
    }

    /**
     *
     * @throws Exception
     *
     * It tests creating trade
     */
    @Test
    @Order(2)
    public void createTradeWithExistingId() throws Exception {
        /**
         *
         * Create trade with existing id 1
         *
         * The request body is:
         * {
         *     "id": 1,
         *     "type": "buy",
         *     "user": {
         *         "id": 2,
         *         "name": "Amy Palmer"
         *     },
         *     "symbol": "AA",
         *     "shares": 11,
         *     "price": 174.82,
         *     "timestamp": "2018-12-28 13:18:48"
         * }
         */
        String json = "{\"id\": 1, \"type\": \"buy\", \"user\": {\"id\": 2, \"name\": \"Amy Palmer\"}, \"symbol\": \"AA\", \"shares\": 11, \"price\": 174.82, \"timestamp\": \"2018-12-28 13:18:48\"}";

        mockMvc.perform(
                post("/trades")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isBadRequest());
    }

    /**
     *
     * @throws Exception
     *
     * It tests finding trade
     */
    @Test
    @Order(3)
    public void findTradeById() throws Exception {
        /**
         *
         * Find trade by id 1
         *
         * The request response is:
         * {
         *     "id": 1,
         *     "type": "buy",
         *     "user": {
         *         "id": 2,
         *         "name": "Amy Palmer"
         *     },
         *     "symbol": "AA",
         *     "shares": 11,
         *     "price": 174.82,
         *     "timestamp": "2018-12-28 13:18:48"
         * }
         */
        String res = "{\"id\": 1, \"type\": \"buy\", \"user\": {\"id\": 2, \"name\": \"Amy Palmer\"}, \"symbol\": \"AA\", \"shares\": 11, \"price\": 174.82, \"timestamp\": \"2018-12-28 13:18:48\"}";

        assertTrue(
                ResultMatcher.matchJson(
                        mockMvc.perform(get("/trades/1"))
                                .andExpect(status().isOk())
                                .andReturn()
                                .getResponse()
                                .getContentAsString(),
                        res,
                        true));
    }

    /**
     *
     * @throws Exception
     *
     * It tests finding trade
     */
    @Test
    @Order(4)
    public void findTradeByNonExistingId() throws Exception {
        /**
         *
         * Find trade by non-existing id 7
         */
        mockMvc.perform(get("/trades/7"))
                .andExpect(status().isNotFound());
    }

    /**
     *
     * @throws Exception
     *
     * It tests finding trades by stock symbol
     */
    @Test
    @Order(5)
    public void findAllTradesByStockSymbol() throws Exception {
        /**
         *
         * Find all the trades by stock symbol A
         *
         * The request response is:
         * [
         *     {
         *         "id": 3,
         *         "type": "buy",
         *         "user": {
         *             "id": 1,
         *             "name": "Briana Ortiz"
         *         },
         *         "symbol": "A",
         *         "shares": 20,
         *         "price": 155.32,
         *         "timestamp": "2019-01-01 11:19:01"
         *     },
         *     {
         *         "id": 6,
         *         "type": "buy",
         *         "user": {
         *             "id": 1,
         *             "name": "Briana Ortiz"
         *         },
         *         "symbol": "A",
         *         "shares": 20,
         *         "price": 155.32,
         *         "timestamp": "2019-01-02 15:42:18"
         *     }
         * ]
         */
        String res = "[{\"id\": 3, \"type\": \"buy\", \"user\": {\"id\": 1, \"name\": \"Briana Ortiz\"}, \"symbol\": \"A\", \"shares\": 20, \"price\": 155.32, \"timestamp\": \"2019-01-01 11:19:01\"}, {\"id\": 6, \"type\": \"buy\", \"user\": {\"id\": 1, \"name\": \"Briana Ortiz\"}, \"symbol\": \"A\", \"shares\": 20, \"price\": 155.32, \"timestamp\": \"2019-01-02 15:42:18\"}]";

        assertTrue(
                ResultMatcher.matchJsonArray(
                        mockMvc.perform(get("/trades/stocks/A"))
                                .andExpect(status().isOk())
                                .andReturn()
                                .getResponse()
                                .getContentAsString(),
                        res,
                        true));
    }

    /**
     *
     * @throws Exception
     *
     * It tests finding trades by non-existing stock symbol
     */
    @Test
    @Order(6)
    public void findAllTradesByNonExistingStockSymbol() throws Exception {
        /**
         *
         * Find all the trades by stock symbol AAP
         */
        mockMvc.perform(get("/trades/stocks/AAP"))
                .andExpect(status().isNotFound());
    }

    /**
     *
     * @throws Exception
     *
     * It tests finding trades by user id
     */
    @Test
    @Order(7)
    public void findAllTradesByUserId() throws Exception {
        /**
         *
         * Find all the trades by user id 1
         *
         * The request response is:
         * [
         *     {
         *         "id": 3,
         *         "type": "buy",
         *         "user": {
         *             "id": 1,
         *             "name": "Briana Ortiz"
         *         },
         *         "symbol": "A",
         *         "shares": 20,
         *         "price": 155.32,
         *         "timestamp": "2019-01-01 11:19:01"
         *     },
         *     {
         *         "id": 5,
         *         "type": "buy",
         *         "user": {
         *             "id": 1,
         *             "name": "Briana Ortiz"
         *         },
         *         "symbol": "AA",
         *         "shares": 11,
         *         "price": 174.82,
         *         "timestamp": "2019-01-02 15:31:49"
         *     },
         *     {
         *         "id": 6,
         *         "type": "buy",
         *         "user": {
         *             "id": 1,
         *             "name": "Briana Ortiz"
         *         },
         *         "symbol": "A",
         *         "shares": 20,
         *         "price": 155.32,
         *         "timestamp": "2019-01-02 15:42:18"
         *     }
         * ]
         */
        String res = "[{\"id\": 3, \"type\": \"buy\", \"user\": {\"id\": 1, \"name\": \"Briana Ortiz\"}, \"symbol\": \"A\", \"shares\": 20, \"price\": 155.32, \"timestamp\": \"2019-01-01 11:19:01\"}, {\"id\": 5, \"type\": \"buy\", \"user\": {\"id\": 1, \"name\": \"Briana Ortiz\"}, \"symbol\": \"AA\", \"shares\": 11, \"price\": 174.82, \"timestamp\": \"2019-01-02 15:31:49\"}, {\"id\": 6, \"type\": \"buy\", \"user\": {\"id\": 1, \"name\": \"Briana Ortiz\"}, \"symbol\": \"A\", \"shares\": 20, \"price\": 155.32, \"timestamp\": \"2019-01-02 15:42:18\"}]";

        assertTrue(
                ResultMatcher.matchJsonArray(
                        mockMvc.perform(get("/trades/users/1"))
                                .andExpect(status().isOk())
                                .andReturn()
                                .getResponse()
                                .getContentAsString(),
                        res,
                        true));
    }

    /**
     *
     * @throws Exception
     *
     * It tests finding trades by non-existing user id
     */
    @Test
    @Order(8)
    public void findAllTradesByNonExistingUserId() throws Exception {
        /**
         *
         * Find all the trades by user id 3
         */
        mockMvc.perform(get("/trades/users/3"))
                .andExpect(status().isNotFound());
    }

    /**
     *
     * @throws Exception
     *
     * It tests finding trades by user id and stock symbol
     */
    @Test
    @Order(9)
    public void findAllTradesByUserIdAndStockSymbol() throws Exception {
        /**
         *
         * Find all the trades by user id 1 and stock symbol A
         *
         * The request response is:
         * [
         *     {
         *         "id": 3,
         *         "type": "buy",
         *         "user": {
         *             "id": 1,
         *             "name": "Briana Ortiz"
         *         },
         *         "symbol": "A",
         *         "shares": 20,
         *         "price": 155.32,
         *         "timestamp": "2019-01-01 11:19:01"
         *     },
         *     {
         *         "id": 6,
         *         "type": "buy",
         *         "user": {
         *             "id": 1,
         *             "name": "Briana Ortiz"
         *         },
         *         "symbol": "A",
         *         "shares": 20,
         *         "price": 155.32,
         *         "timestamp": "2019-01-02 15:42:18"
         *     }
         * ]
         */
        String res = "[{\"id\": 3, \"type\": \"buy\", \"user\": {\"id\": 1, \"name\": \"Briana Ortiz\"}, \"symbol\": \"A\", \"shares\": 20, \"price\": 155.32, \"timestamp\": \"2019-01-01 11:19:01\"}, {\"id\": 6, \"type\": \"buy\", \"user\": {\"id\": 1, \"name\": \"Briana Ortiz\"}, \"symbol\": \"A\", \"shares\": 20, \"price\": 155.32, \"timestamp\": \"2019-01-02 15:42:18\"}]";

        assertTrue(
                ResultMatcher.matchJsonArray(
                        mockMvc.perform(get("/trades/users/1/stocks/A"))
                                .andExpect(status().isOk())
                                .andReturn()
                                .getResponse()
                                .getContentAsString(),
                        res,
                        true));
    }

    /**
     *
     * @throws Exception
     *
     * It tests finding trades by user id and stock symbol
     */
    @Test
    @Order(10)
    public void findAllTradesByNonExistingUserIdAndNonExistingStockSymbol() throws Exception {
        /**
         *
         * Find all the trades by non-existing user id 4 and non-existing stock symbol AAP
         */
        mockMvc.perform(get("/trades/users/4/stocks/AAP"))
                .andExpect(status().isNotFound());
    }

    /**
     *
     * @throws Exception
     *
     * It tests finding trades by user id and stock symbol
     */
    @Test
    @Order(11)
    public void findAllTradesByUserIdAndNonExistingStockSymbol() throws Exception {
        /**
         *
         * Find all the trades by user id 1 and non-existing stock symbol AAP
         */
        mockMvc.perform(get("/trades/users/1/stocks/AAP"))
                .andExpect(status().isNotFound());
    }

    /**
     *
     * @throws Exception
     *
     * It tests finding trades by user id and stock symbol
     */
    @Test
    @Order(12)
    public void findAllTradesByNonExistingUserIdAndStockSymbol() throws Exception {
        /**
         *
         * Find all the trades by non-existing user id 4 and stock symbol A
         */
        mockMvc.perform(get("/trades/users/4/stocks/A"))
                .andExpect(status().isNotFound());
    }

    /**
     *
     * @throws Exception
     *
     * It tests finding all the trades
     */
    @Test
    @Order(13)
    public void findAllTrades() throws Exception {
        /**
         *
         * Find all the trades
         *
         * The request response is:
         * [
         *     {
         *         "id": 1,
         *         "type": "buy",
         *         "user": {
         *             "id": 2,
         *             "name": "Amy Palmer"
         *         },
         *         "symbol": "AA",
         *         "shares": 11,
         *         "price": 174.82,
         *         "timestamp": "2018-12-28 13:18:48"
         *     },
         *     {
         *         "id": 2,
         *         "type": "buy",
         *         "user": {
         *             "id": 2,
         *             "name": "Amy Palmer"
         *         },
         *         "symbol": "AA",
         *         "shares": 11,
         *         "price": 174.82,
         *         "timestamp": "2018-12-29 09:47:43"
         *     },
         *     {
         *         "id": 3,
         *         "type": "buy",
         *         "user": {
         *             "id": 1,
         *             "name": "Briana Ortiz"
         *         },
         *         "symbol": "A",
         *         "shares": 20,
         *         "price": 155.32,
         *         "timestamp": "2019-01-01 11:19:01"
         *     },
         *     {
         *         "id": 4,
         *         "type": "buy",
         *         "user": {
         *             "id": 2,
         *             "name": "Amy Palmer"
         *         },
         *         "symbol": "AA",
         *         "shares": 11,
         *         "price": 174.82,
         *         "timestamp": "2019-01-01 12:02:03"
         *     },
         *     {
         *         "id": 5,
         *         "type": "buy",
         *         "user": {
         *             "id": 1,
         *             "name": "Briana Ortiz"
         *         },
         *         "symbol": "AA",
         *         "shares": 11,
         *         "price": 174.82,
         *         "timestamp": "2019-01-02 15:31:49"
         *     },
         *     {
         *         "id": 6,
         *         "type": "buy",
         *         "user": {
         *             "id": 1,
         *             "name": "Briana Ortiz"
         *         },
         *         "symbol": "A",
         *         "shares": 20,
         *         "price": 155.32,
         *         "timestamp": "2019-01-02 15:42:18"
         *     }
         * ]
         */
        String res = "[{\"id\": 1, \"type\": \"buy\", \"user\": {\"id\": 2, \"name\": \"Amy Palmer\"}, \"symbol\": \"AA\", \"shares\": 11, \"price\": 174.82, \"timestamp\": \"2018-12-28 13:18:48\"}, {\"id\": 2, \"type\": \"buy\", \"user\": {\"id\": 2, \"name\": \"Amy Palmer\"}, \"symbol\": \"AA\", \"shares\": 11, \"price\": 174.82, \"timestamp\": \"2018-12-29 09:47:43\"}, {\"id\": 3, \"type\": \"buy\", \"user\": {\"id\": 1, \"name\": \"Briana Ortiz\"}, \"symbol\": \"A\", \"shares\": 20, \"price\": 155.32, \"timestamp\": \"2019-01-01 11:19:01\"}, {\"id\": 4, \"type\": \"buy\", \"user\": {\"id\": 2, \"name\": \"Amy Palmer\"}, \"symbol\": \"AA\", \"shares\": 11, \"price\": 174.82, \"timestamp\": \"2019-01-01 12:02:03\"}, {\"id\": 5, \"type\": \"buy\", \"user\": {\"id\": 1, \"name\": \"Briana Ortiz\"}, \"symbol\": \"AA\", \"shares\": 11, \"price\": 174.82, \"timestamp\": \"2019-01-02 15:31:49\"}, {\"id\": 6, \"type\": \"buy\", \"user\": {\"id\": 1, \"name\": \"Briana Ortiz\"}, \"symbol\": \"A\", \"shares\": 20, \"price\": 155.32, \"timestamp\": \"2019-01-02 15:42:18\"}]";

        assertTrue(
                ResultMatcher.matchJsonArray(
                        mockMvc.perform(get("/trades"))
                                .andExpect(status().isOk())
                                .andReturn()
                                .getResponse()
                                .getContentAsString(),
                        res,
                        true));
    }
}
