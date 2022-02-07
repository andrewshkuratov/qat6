package edu.sumdu.tss.unit.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.javalin.http.Context;
import edu.sumdu.tss.elephant.model.Database;
import edu.sumdu.tss.elephant.model.User;
import io.javalin.Javalin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.fge.msgsimple.bundle.MessageBundle;

public class AbstractControllerTest {
    // @Test
    // void currentUser() {
    //     AbstractController cls = Mockito.mock(AbstractController.class);
    //     Context context = new Context();
    //     User expected = new User();
    //     Mockito.doCallRealMethod()
    //     .when(cls)
    //     .currentUser(context);
    //     assertEquals(expected, cls.currentUser(context));
    // }

    // @Test
    // void currentDB() {
    //     AbstractController cls = Mockito.mock(AbstractController.class);
    //     Context context = new Context(null, null, null);
    //     Database expected = new Database();
    //     Mockito.doCallRealMethod()
    //     .when(cls)
    //     .currentDB(context);
    //     assertEquals(expected, cls.currentDB(context));
    // }

    // @Test
    // void currentMessages() {
    //     AbstractController cls = Mockito.mock(AbstractController.class);
    //     Context context = new Context(null, null, null);
    //     MessageBundle expected = new MessageBundle();
    //     Mockito.doCallRealMethod()
    //     .when(cls)
    //     .currentMessages(context);
    //     assertEquals(expected, cls.currentMessages(context));
    // }

    // @Test
    // void currentModel() {
    //     AbstractController cls = Mockito.mock(AbstractController.class);
    //     Context context = new Context(null, null, null);
    //     Map<String, Object> expected = new Map<String, Object>(null,null);
    //     Mockito.doCallRealMethod()
    //     .when(cls)
    //     .currentModel(context);
    //     assertEquals(expected, cls.currentModel(context));
    // }
}
