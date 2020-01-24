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
public class OrderService {

    @Test
    class void placeOrder() throws Exception {
        Task order = task(sig("small_menu", OrderService.class), new Order(), context(
                inVal("address", "Koszykowa 86"),
                inVal("price", 30)));

        Task set_address = task("address", sig("setAddress"), OrderService.class, "Koszykowa 86");
        Task place_order = task("order", sig("placeOrder"), OrderService.class, Order order = new Order())

        Job todo = job("job", sig("exert", ServiceJobber.class), order, set_address, place_order);

        Context out = upcontext(exert(todo));

        assertEquals(value(out, "order/adsress"), "Koszykowa 86");
        assertEquals(value(out, "order/price"), order.getPrice());
    }

}