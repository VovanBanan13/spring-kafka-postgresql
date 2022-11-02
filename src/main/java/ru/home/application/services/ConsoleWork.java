//package ru.home.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import ru.home.data.Item;
//
//import java.util.List;
//
//@Component
//public class ConsoleWork implements CommandLineRunner {
//    private final JsonParser jsonParser;
//
//    @Autowired
//    public ConsoleWork(JsonParser jsonParser) {
//        this.jsonParser = jsonParser;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("\n\n\tНачало работы:\n\n");
//        String jsonFileJackson = "src/main/resources/itemList.json";
//
//        List<Item> itemList = jsonParser.parseJacksonFile(jsonFileJackson);
//        System.out.println(itemList);
//
//    }
//}
