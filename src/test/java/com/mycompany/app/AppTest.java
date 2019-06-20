package com.mycompany.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.norberg.automatter.jackson.AutoMatterModule;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AppTest {
  private ObjectMapper objectMapper;

  @Before
  public void setUp() {
    objectMapper = new ObjectMapper().registerModule(new AutoMatterModule());
  }

  @Test
  public void testApp() throws Exception {
    Foobar foobar = new FoobarBuilder()
        .foo("foo")
        .bar("bar")
        .build();

    String json = objectMapper.writeValueAsString(foobar);
    System.out.println("serialized: " + json);

    // throws com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException:
    //     Unrecognized field "empty" (class java.util.Optional),
    //     not marked as ignorable (0 known properties: ])
    Foobar parsed = objectMapper.readValue(json, Foobar.class);

    System.out.println("foobar.foo: " + parsed.foo());
    System.out.println("foobar.bar: " + parsed.bar().get());
  }
}
