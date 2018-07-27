import java.util.concurrent.CountDownLatch

import org.springframework.stereotype.Component

@Component
class Receiver {

  val latch : CountDownLatch = new CountDownLatch(1);

  def receiveMessage(msg: String) = {
      print(s"Received < $msg > ")
      latch.countDown()
  }

  def getLatch: CountDownLatch = {
      latch
  }

}
