package template.libraries.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Content implements Serializable {
	public Map<String, Boolean> attach;
	public String nid;
	public String datum;
	public String naslov;
	public String tekst;

	public Content() {
		attach=new HashMap<String, Boolean>();
	}

	public boolean filter(String word) {
		word=word.trim();
		if(word.isEmpty()) {
			return true;
		}

		boolean filter=naslov.contains(word) ||tekst.contains(word);
		if(filter) {
			return true;
		}

		//empty naslov and tekst would satisfy always,
		//so we should ignore them
		if(!naslov.isEmpty()) {
			filter=word.contains(naslov);
		}
		if(!tekst.isEmpty()) {
			filter=word.contains(tekst);
		}

		return filter;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getTekst() {
		return tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
}
