package ru.job4j.jdbc;

import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TableEditorTest {
    Properties properties = new Properties();

    @Test
    public void whenCreateAddRenameDrop() throws SQLException, IOException, ClassNotFoundException {
        TableEditor te = new TableEditor(properties);
        te.createTable("test_table");
        te.addColumn("test_table", "test_name", "varchar(255)");
        assertThat(te.getScheme("test_table"), is(
                "column          type           \n" +
                        "id              serial         \n" +
                        "test_name       varchar        \n"));
        te.renameColumn("test_table", "test_name", "new_name");
        assertThat(te.getScheme("test_table"), is(
                "column          type           \n" +
                        "id              serial         \n" +
                        "new_name        varchar        \n"));
        te.dropColumn("test_table", "new_name");
        assertThat(te.getScheme("test_table"), is(
                "column          type           \n" +
                        "id              serial         \n"));
        te.dropTable("test_table");
        assertThat(te.getScheme("test_table"), is(
                "column          type           \n"));
    }
}