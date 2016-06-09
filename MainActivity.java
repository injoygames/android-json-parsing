public class MainActivity extends ActionBarActivity {
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layot.activity_main);
    
    HttpURLConnection connection;
    BufferedReader reader;
    
    try {
      URL url = new URL("place_url_here");
      connection = (HttpURLConnection) url.openConnection();
      connection.connect();
      
      InputStream stream = connection.getInputStream();
      
      reader = new BufferedReader(new InputStreamReader(stream));
      
      StringBuffer buffer = new StringBuffer();
      
      String line = "";
      while ((line = reader.readLine()) != null){
        buffer.append(line);
      }
      
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e){
      e.printStackTrace();
    } finally {
      if(connection != null) {
        connection.disconnect();
      }
      try {
        if (reader != null){
          reader.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
        
      }
  }
}
