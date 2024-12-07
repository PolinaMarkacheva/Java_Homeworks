import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient
{
    //Отправляет запрос на API
    private static String sendGetRequest(String url) throws Exception
    {
        //Соединяет с API
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //Отправляет запрос на получение данных
        con.setRequestMethod("GET");

        //Получает ответ с API
        int responseCode = con.getResponseCode();
        System.out.println("Response Code : " + responseCode);
        if (responseCode != HttpURLConnection.HTTP_OK)
        {
            throw new RuntimeException("Failed: HTTP error code: " + responseCode);
        }

        //Читает ответ
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        //Сохраняет ответ в строку
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    //Отображает ответ на запрос вместе с парсингом JSON
    private static void displayResponse(String jsonResponse)
    {
        System.out.println("Response:");
        System.out.println(jsonResponse);
    }

    //URL парсинг
    private static void URL_Parsing(String url) throws Exception
    {
        URL obj = new URL(url);
        System.out.println("1. The protocol is " + obj.getProtocol());
        System.out.println("2. The host is " + obj.getHost());
        System.out.println("3. The port is " + obj.getPort());
        System.out.println("4. The file is " + obj.getFile());
        System.out.println("5. The anchor is " + obj.getRef());

    }

    public static void main(String[] args)
    {
        try
        {
            //2 ссылки на API
            String todosUrl = "https://dummy-json.mock.beeceptor.com/todos";
            String companiesUrl = "https://fake-json-api.mock.beeceptor.com/companies";

            //Парсинг URL
            System.out.println("URL парсинг To-do-Tasks: ");
            URL_Parsing(todosUrl);
            System.out.println("URL парсинг Companies: ");
            URL_Parsing(companiesUrl);

            //Отправка запросов
            System.out.println("Результаты запросов от To-Do-Tasks: ");
            String todosResponse = sendGetRequest(todosUrl);
            displayResponse(todosResponse);
            System.out.println("Результаты запросов от Companies: ");
            String companiesResponse = sendGetRequest(companiesUrl);
            displayResponse(companiesResponse);
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
}