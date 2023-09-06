import java.util.HashMap;

public class LegoBody implements ToyPart{
    // Create a new HashMap to store image paths
    private HashMap<String, String> imagePaths;
    private int actual = 1;
    private int totalImages = 14;

    // Constructor
    public LegoBody() {
        imagePaths = new HashMap<>();
        
        // Populate the HashMap with key-value pairs
        for (int i = 1; i <= totalImages; i++) {
            String key = String.valueOf(i);  // Convert int to String
            String value = "img/lego/Cuerpos/cuerpo" + key + ".png";
            imagePaths.put(key, value);
        }
    }

    @Override
    public String getPath() {
        // Implement your logic here. For example, return a default path.
        return imagePaths.get(String.valueOf(actual));  // Convert int to String before fetching
    }

    @Override
    public String getPathRight() {
        actual = (actual % totalImages) + 1;  // Increment and loop back if needed
        return imagePaths.get(String.valueOf(actual));
    }

    @Override
    public String getPathLeft() {
        actual = (actual - 2 + totalImages) % totalImages + 1;  // Decrement and loop back if needed
        return imagePaths.get(String.valueOf(actual));
    }
}
