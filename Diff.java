package application;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import com.github.difflib.DiffUtils;
import com.github.difflib.patch.AbstractDelta;
import com.github.difflib.patch.DeltaType;
import com.github.difflib.patch.Patch;

public class Diff {
	public static void main(String[] args) {
		
        List<String> original = fileToLines("C:/Users/Joe/Documents/Java/DatabaseTableview/src/application/html1.html");
        List<String> revised  = fileToLines("C:/Users/Joe/Documents/Java/DatabaseTableview/src/application/html2.html");

        Patch<String> patch = DiffUtils.diff(original, revised);
        
        for (AbstractDelta<String> delta: patch.getDeltas()) {
            System.out.println(delta);
        }
	}
	private static List fileToLines(String filename) { 
		List lines = new LinkedList(); 
		String line = ""; 
		try { 
			BufferedReader in = new BufferedReader(new FileReader(filename)); 
			while ((line = in.readLine()) != null) 
			{ 
				lines.add(line); 
			} }
			catch (IOException e) 
			{ 
				e.printStackTrace(); 
			} 
			return lines; 				
	}
}


