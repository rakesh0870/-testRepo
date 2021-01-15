package autosuggest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test1 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("CAT", "DOG", "TAC", "MAD", "DAM", "AMD", "GOD", "SET");

		Map<String, List<String>> map = new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			String elementI = list.get(i);
			char[] charArray = elementI.toCharArray();
			for (int j = 0; j < list.size(); j++) {
				boolean check = false;
				String elementJ = list.get(j);
				for (char c : charArray) {
					if (elementJ.contains(String.valueOf(c))) {
						check = true;
					} else {
						check = false;
						break;
					}
				}
				if (check) {
					List<String> list2;
					if (map.containsKey(elementI)) {
						list2 = map.get(elementI);
					} else {
						list2 = new ArrayList<String>();
					}
					list2.add(elementJ);
					map.put(elementI, list2);
				}
			}
		}
		Set<List<String>> set = new HashSet<List<String>>(map.values());
		System.out.println(set);
	}
}
