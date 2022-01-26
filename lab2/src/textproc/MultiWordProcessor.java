package textproc;

// import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MultiWordProcessor implements TextProcessor {
	Map<String, Integer> m = new TreeMap<>();
	
	public MultiWordProcessor(String[] s) {
		for(int i = 0; i < s.length; i++){
	        m.put(s[i], 0);
		}
	}
	
	@Override
	public void process(String w) {
		for (String key : m.keySet()) {
			if (w.equals(key)) {
				m.put(key, m.get(key) + 1);
			}
		}
	}

	@Override
	public void report() {
		System.out.println("MultiWordCounter: ");
		for (String key : m.keySet()) {
			System.out.println(key + ": " + m.get(key));
		}
	}
}