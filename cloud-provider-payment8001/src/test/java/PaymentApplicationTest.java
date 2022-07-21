import com.entity.domain.Payment;
import com.payment.PaymentApplication8001;
import com.payment.service.impl.PaymentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xiaxl
 * @version v1.0
 * @ClassName PaymentApplicationTest
 * @Descrption TODO
 * @date 2022/7/12 16:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PaymentApplication8001.class)
public class PaymentApplicationTest {

    @Autowired
    private PaymentServiceImpl paymentService;

    @Test
    public void demo(){
        Payment payment = paymentService.selectPaymentById(1L);
        System.out.println(payment.getSerial());
    }
}
