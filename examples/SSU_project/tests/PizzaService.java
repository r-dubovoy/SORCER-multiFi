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
public class PizzaService {

    @Test
    public void createPizza() throws Exception {

        Task pizza = task(sig("default_pepperoni", PizzaService.class), new Pizza(), context(
                inVal("name", "pepperoni"),
                inVal("price", 30)));

        Task add_ingredients = task("topping_1", sig("addEngradient"), PizzaService.class, "tomatoes");
        Task increase_price = task("modified_pepperoni_price", sig("increasePrice"), PizzaService.class, 5, val("default_pepperoni/price"));
        Task add_ingredients2 = task("topping_2", sig("addEngradient"), PizzaService.class, "mushrooms");
        Task increase_price2 = task("modified_pepperoni_price", sig("increasePrice"), PizzaService.class, 8, val("modified_peperoni/price"));

        Job todo = job("job", sig("exert", ServiceJobber.class), pizza, add_ingredients, increase_price, add_ingredients2, increase_price2);

        Context out = upcontext(exert(todo));

        assertEquals(value(out, "default_pepperoni/price"), 30);
        assertEquals(value(out, "job/modified_pepperoni_price"), 43);
    }
}