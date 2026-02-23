package by.matusevich.sort.app.strategy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

import by.matusevich.sort.app.model.User;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Nested
public class StrategyTest {
    private User user1 = User.builder().setName("Alex").setEmail("Aboba@gmail.com").setPassword("A12345").build();
    private User user2 = User.builder().setName("Calvin").setEmail("calvin111@gmail.com").setPassword("qq12345").build();
    private User user3 = User.builder().setName("Boris").setEmail("borisbritva@mail.ru").setPassword("qq12345Q").build();

    @Nested
    @DisplayName("Email Test")
    class EmailStrategyTest {
        @Test
        @DisplayName("Email by Ascend")
        public void EmailByAscStrategyTest() {
            EmailByAscStrategy strategy = new EmailByAscStrategy();
            assertTrue(strategy.compare(user1, user2) < 0, "Calvin after Alex");
            assertTrue(strategy.compare(user1, user3) < 0, "Boris after Alex");
            assertTrue(strategy.compare(user2, user3) > 0, "Calvin after Boris");
            assertEquals(0, strategy.compare(user1, user1), "0");
        }
    }

    @Test
    @DisplayName("Email by Descend")
    public void EmailByDescStrategyTest() {
        EmailByDescStrategy strategy = new EmailByDescStrategy();
        assertTrue(strategy.compare(user1, user2) > 0, "Alex after Calvin");
        assertTrue(strategy.compare(user1, user3) > 0, "Alex after Boris");
        assertTrue(strategy.compare(user2, user3) < 0, "Boris after Calvin");
        assertEquals(0, strategy.compare(user1, user1), "0");
    }

    @Nested
    @DisplayName("First name test")
    class FirstNameTest {
        @Test
        @DisplayName("First name by Ascend")
        public void FirstNameByAscStrategyTest() {
            FirstNameByAscStrategy strategy = new FirstNameByAscStrategy();
            assertTrue(strategy.compare(user1, user2) < 0, "Calvin after Alex");
            assertTrue(strategy.compare(user1, user3) < 0, "Boris after Alex");
            assertTrue(strategy.compare(user2, user3) > 0, "Calvin after Boris");
            assertEquals(0, strategy.compare(user1, user1), "0");
        }
    }

    @Test
    @DisplayName("First name by Descend")
    public void FirstNameByDescStrategyTest() {
        FirstNameByDescStrategy strategy = new FirstNameByDescStrategy();
        assertTrue(strategy.compare(user1, user2) > 0, "Alex after Calvin");
        assertTrue(strategy.compare(user1, user3) > 0, "Alex after Boris");
        assertTrue(strategy.compare(user2, user3) < 0, "Boris after Calvin");
        assertEquals(0, strategy.compare(user2, user2), "0");
    }

    @Nested
    @DisplayName("Password test")
    class PasswordStrategyTest {
        @Test
        @DisplayName("Password by ascend")
        public void PasswordByAscStrategyTest() {
            PasswordByAscStrategy strategy = new PasswordByAscStrategy();
            assertTrue(strategy.compare(user1, user2) < 0, "A12345 should be before qq12345");
            assertTrue(strategy.compare(user1, user3) < 0, "A12345 should be before qq12345Q");
            assertTrue(strategy.compare(user2, user3) < 0, "qq12345 should be before qq12345Q");
            assertEquals(0, strategy.compare(user1, user1), "Same user should return 0");
        }
    }

    @Test
    @DisplayName("Password by Descend")
    public void PasswordByDescStrategyTest() {
        PasswordByDescStrategy strategy = new PasswordByDescStrategy();
        assertTrue(strategy.compare(user1, user2) > 0, "qq12345 should be before A12345");
        assertTrue(strategy.compare(user1, user3) > 0, "qq12345Q should be before A12345");
        assertTrue(strategy.compare(user2, user3) > 0, "qq12345Q should be before qq12345");
        assertEquals(0, strategy.compare(user1, user1), "Same user should return 0");
    }

    @Nested
    @DisplayName("Password Length test")
    class PasswordLengthStrategyTest {
        @Test
        @DisplayName("Pass length by Ascend")
        public void PasswordLengthByAscStrategyTest() {
            PasswordLengthByAscStrategy strategy = new PasswordLengthByAscStrategy();
            assertTrue(strategy.compare(user1, user2) == 0, "Same length should return 0");
            assertTrue(strategy.compare(user1, user3) < 0, "Length 6 should be before length 7");
            assertTrue(strategy.compare(user2, user3) < 0, "Length 6 should be before length 7");
            assertEquals(0, strategy.compare(user2, user1), "Same length should return 0");
        }
    }

    @Test
    @DisplayName("Pass length by desc")
    public void PasswordLengthByDescStrategyTest() {
        PasswordLengthByDescStrategy strategy = new PasswordLengthByDescStrategy();
        assertTrue(strategy.compare(user1, user2) == 0, "Same length should return 0");
        assertTrue(strategy.compare(user1, user3) > 0, "Length 7 should be before length 6");
        assertTrue(strategy.compare(user2, user3) > 0, "Length 7 should be before length 6");
        assertEquals(0, strategy.compare(user1, user1), "Same user should return 0");
    }


}
