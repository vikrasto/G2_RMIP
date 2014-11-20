package tests.manageControl;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by idnvra on 10-10-2014.
 */
public class Learning {
        @BeforeClass
        public void testBeforeClass() {
            System.out.println("Inside BeforeClass");

        }
        @AfterClass
        public void testAfterClass() throws InterruptedException {
            TimeUnit.SECONDS.sleep(10);
            System.out.println("Inside AfterClass");
        }
        @Test
        public void testSetUp() throws InterruptedException {
            TimeUnit.SECONDS.sleep(10);
            System.out.println("Inside TestSetUp");
        }
        @Test
        public void testTearDown() throws InterruptedException {
            TimeUnit.SECONDS.sleep(10);
            System.out.println("Inside TestTearDown");
        }
  }

