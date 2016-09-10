package miyamoto.apartmentlist;

public class DescriptionSnippets{
	public String generateSnippets(String document, String query){
		StringBuilder snippets = new StringBuilder();
		String[] removeIntro = document.split(":");
		String[] descriptions = removeIntro[1].split(";");
		String[] keyWords = query.split(" ");
		boolean didRemoveSpaces = false;

		for(int i = 0; i < descriptions.length; i++){
			if(containsKeyword(descriptions[i], keyWords)){
				String desc = descriptions[i];
				if(!didRemoveSpaces){
					desc = removeLeadingSpaces(desc); // if first sentence has leading spaces, they need to be removed.
					didRemoveSpaces = true;
				}
				//"the final item in the descriptions doesn't have ";"
				if(i ==descriptions.length-1){
					snippets.append(desc);
				}
				else{
					snippets.append(desc+";");
				}
			}

		}

		return snippets.toString();
	}

	public String generateSnippets2(String document, String query){
		StringBuilder snippets = new StringBuilder();
		String[] removeIntro = document.split(":");
		String[] descriptions = removeIntro[1].split(";");
		String[] keyWords = query.split(" ");
		int start = -1;
		int end = -1;
		for(int i = 0; i < descriptions.length; i++){
			if(containsKeyword(descriptions[i], keyWords)){
				if(start == -1){
					start = i;
				}
				else{
					end = i;
					break;
				}
			}
		}
		if(end == -1 && start != -1){ // if it only finds one keyword, use the start index
			end = start;
		}

		if(start != -1 && end != -1){
			boolean didRemoveSpaces = false;
			for(int i = start; i <= end; i++){
				String desc = descriptions[i];
				if(!didRemoveSpaces){
					desc = removeLeadingSpaces(desc); // if first sentence has leading spaces, they need to be removed.
					didRemoveSpaces = true;
				}
				//"the final item in the descriptions doesn't have ";"
				if(i ==descriptions.length-1){
					snippets.append(desc);
				}
				else{
					snippets.append(desc+";");
				}

			}
		}
		return snippets.toString();
	}

	private boolean containsKeyword(String description, String[] keyWords){
		for(int i = 0; i < keyWords.length; i++){
			if(description.toLowerCase().contains(keyWords[i].toLowerCase())){
				return true;
			}
		}
		return false;
	}

	String removeLeadingSpaces(String desc){ // using default access modifier for testing purpose. private would be prefer
		String noLeadingSpaces = desc;
		while(noLeadingSpaces.length() > 0) {
			if(noLeadingSpaces.charAt(0) == ' '){
				noLeadingSpaces = noLeadingSpaces.substring(1);
			}
			else{
				break;
			}
		}
		return noLeadingSpaces;
	}

}