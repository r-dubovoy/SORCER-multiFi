package tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sorcer.test.ProjectContext;
import org.sorcer.test.SorcerTestRunner;
import sorcer.core.provider.rendezvous.ServiceJobber;
import sorcer.service.*;
import src.main.Pizza;
import src.main.Order;
import src.main.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static sorcer.co.operator.inPaths;
import static sorcer.co.operator.inVal;
import static sorcer.co.operator.val;
import static sorcer.ent.operator.ent;
import static sorcer.eo.operator.*;
import static sorcer.mo.operator.value;
import static sorcer.so.operator.eval;
import static sorcer.so.operator.exec;
import static sorcer.so.operator.exert;

@RunWith(SorcerTestRunner.class)
public class DeliveryService {

    @Test
    class void receiveOrder() throws Exception {
        Task order = task(sig("regular_order", DeliveryService.class), User user, context(
                inVal("uder_id", 42069),
                inVal("balance", 12345)));

        Task add_order = task("order", sig("recieveOrder"), DeliveryService.class, "order");
        Task withdraw_funds = task("balance_after_withdraw", sig("withdrawFromAccount"), DeliveryService.class, order.getPrice(), val("balance_before_withdraw"));
        Task add_to_order_history = task("order", sig("addToOrderHistory"), DeliveryService.class, "order");

        Job todo = job("job", sig("exert", ServiceJobber.class), user, add_order, withdraw_funds, add_to_order_history);

        Context out = upcontext(exert(todo));

        assertEquals(value(out, "balance_before_withdraw"), 12345);
        assertEquals(value(out, "balance_after_withdraw"), (12345 - order.getPrice()));
        assertEquals(value(out, "lastOrderInHistory"), order);
    }

}