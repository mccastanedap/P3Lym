package importar;

import java.util.ArrayList;

import cern.colt.Arrays;

public class ValidarVariables {
	
	
	
	public static boolean validar(String cadena)
	{
		System.out.println(cadena);
		ArrayList<String>tokens= new ArrayList<String>();
		String[] token = new String[] { "ROBOT_R","BEGIN","assign:","to:","assign:",
				"move:","turn:","front", "back","left", "right", "around", "face:", "put:", "of:", "pick:", "toThe:", "inDir:", "Chips",
				"Ballons", "north", "south", "east", "west","if:", "then:", "else:" ,"while:", "do:", "repeat:", "times:", "facing:",
				"canPut:", "canPick:","not:", "canMove:","END"};
		for(String e: token)
		{	
		tokens.add(e);
		}
	
		String[] data = cadena.split(" ");
		ArrayList<String> variables = new ArrayList<String>();
		ArrayList<String> cmp = new ArrayList<String>();
		boolean var= false;
		for(String d : data)
		{
			if(d== null || d.equals("")|| d.equals(" ") || d.equals(",")  )
			{
				continue;
			}
			if (d.equals("VARS"))
			{
				var= true;
			}
			else if (tokens.contains(d)){
				if(var){
					var= false;
				}
				continue;
			}
			else {
				try{
					Integer.parseInt(d);
					if(var){
						var= false;
					}
					continue;
				}
				catch(Exception e){
					String x = d.replaceAll(",", "");
					if(var){
						variables.add(x);
						
					}
					else{
						cmp.add(x);
					}
				}
			}
		}
	
		System.out.println(variables);
		System.out.println(cmp);
		return variables.containsAll(cmp);
	}
}
