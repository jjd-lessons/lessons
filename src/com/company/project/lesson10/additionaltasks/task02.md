### Реализовать функционал логгеров

1. Набор логгеров, каждый из них выполняет запись данных и может использоваться самостоятельно
    1) ConsoleWriter - пишет данные в консоль
    2) AppFileWriter - пишет данные в файл
2. Набор классов, которые помогают логгерам преобразовывать данные перед выводом. Классы - преобразователи не могут
   использоваться самостоятельно. Они всегда создаются с другими преобразователями или с логгерами. 
3. Пример использования логгеров и преобразователей представлен ниже


        public class LoggerTask {
            public static void main(String[] args) {

                AppLogger logger01 = new Delimiter(new Upper(new ConsoleWriter()));
    
                // к сообщению будет добавлен символ точки с запятой (;) - возможности Delimiter
                // текст сообщения будет приведен к верзнему регистру  - возможности Upper
                // данные будут выведены в консоль  - возможности ConsoleWriter
                logger01.log("сообщение"); 
    
                AppLogger logger02 = new Upper(new Delimiter(new AppFileWriter("file.txt")));
    
                // текст сообщения будет приведен к верзнему регистру  - возможности Upper
                // к сообщению будет добавлен символ точки с запятой (;) - возможности Delimiter
                // данные будут записаны в файл  - возможности ConsoleWriter
                logger02.log("сообщение");
    
                ConsoleWriter console = new ConsoleWriter();
                console.log("данные"); // данные будут выведены в консоль
    
                AppFileWriter file = new AppFileWriter("file.txt");
                file.log("данные"); // данные будут записаны в файл
            }
        }

4. Для записи в файл использовать следующие инструкции


         String filename = "file.txt";
         String data = "сообщение";
         try {
             Files.writeString(Path.of(filename), data, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
