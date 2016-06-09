public class MainActivity extends ActionBarActivity {
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layot.activity_main);
    
    HttpURLConnection connection;
    
    try {
      URL url = new URL("place_url_here");
      connection = (HttpURLConnection) url.openConnection();
      connection.connect();
      
      InputStream stream = connection.getInputStream();
      
      BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
      
      StringBuffer buffer = new StringBuffer();
      
      String line = "";
      while ((line = reader.readLine()) != null){
        buffer.append(line);
      }
      
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e){
      e.printStackTrace();
    }
  }
}
