package textproc;

import java.util.ArrayList;
// import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class GeneralWordCounter implements TextProcessor{
	private Map<String, Integer> m;
	private Set<String> s;
	
	public GeneralWordCounter(HashSet<String> set) {
		this.s = set;
		this.m = new TreeMap<String, Integer>();
	}

	@Override
	public void process(String w) {
		if (!s.contains(w)) {
			if (m.containsKey(w)) {
				m.put(w, m.get(w) + 1);
			} else {
				m.put(w, 1);
			}
		}
	}

	@Override
	public void report() {
		System.out.println("GeneralWordCounter: ");
		/*
		m.forEach( 
	            (key, value) 
	                -> {if (200<value) System.out.println(key + ": " + value);
	                }
		);
		*/
		Set<Map.Entry<String, Integer>> wordSet = m.entrySet();
		List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);
		wordList.sort(new WordCountComparator());
		for (int i = 0; i<5; i++) {
			System.out.println(wordList.get(i).getKey() + ": " + wordList.get(i).getValue());
		}
	}

}
