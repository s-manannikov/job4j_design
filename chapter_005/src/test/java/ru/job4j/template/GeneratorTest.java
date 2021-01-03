package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;
import java.util.Map;

import static org.junit.Assert.*;

public class GeneratorTest {

    @Ignore
    @Test
    public void whenProduce() {
        Generator gen = new TemplateGenerator();
        String template = "Let the ${subject} be with ${name}!";
        Map<String, String> map = Map.of(
                "subject", "force",
                "name", "you"
        );
        assertEquals(gen.produce(template, map), "Let the force be with you!");
    }

    @Ignore
    @Test (expected = Exception.class)
    public void whenNoKey() {
        Generator gen = new TemplateGenerator();
        String template = "Let the ${subject} be with ${name} and ${name2}!";
        Map<String, String> map = Map.of(
                "subject", "force",
                "name", "you"
        );
        gen.produce(template, map);
    }

    @Ignore
    @Test (expected = Exception.class)
    public void whenTooManyKeys() {
        Generator gen = new TemplateGenerator();
        String template = "Let the ${subject} be with ${name}!";
        Map<String, String> map = Map.of(
                "subject", "force",
                "name", "you",
                "name2", "me"
        );
        gen.produce(template, map);
    }
}