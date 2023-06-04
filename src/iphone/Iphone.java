package iphone;

import java.util.ArrayList;
import java.util.List;

public class Iphone implements MusicPlayer, MobilePhone, InternetBrowser{

	private String name = "Iphone";
	private String year = "2007";
	private String number = "";
	private List<String> musicList = new ArrayList<>();
	private String selectedMusic = "";
	private Boolean isPlayingMusic = false;
	private String selectedPage = "";
	private int tabs = 0;
	private Boolean isCalling = false;
	private List<String> messageList = new ArrayList<>();
	private Iphone iphoneCalling;
	
	public static void main(String[] args) {
		
		Iphone iphone = new Iphone();
		Iphone newIphone = new Iphone();
		
		newIphone.setName("Iphone 5");
		newIphone.setYear("2017");
		
		iphone.setNumber("+55 11 1234567890");
		newIphone.setNumber("+55 1 0123456789");
		
		iphone.play();
		
		iphone.addMusic("Believer");
		iphone.addMusic("Believer");
		
		
		newIphone.addMusic("Imagine Dragons");
		newIphone.addMusic("Talking to the Moon");
		
		iphone.play();
		newIphone.play();
		
		iphone.call(newIphone);
		
		iphone.selectMusic();
		newIphone.selectMusic("Believer");
		
		iphone.addNewTab();
		
		iphone.viewSite("Facebook");
		newIphone.viewSite("Google");
		
		newIphone.addNewTab();
		newIphone.deleteTab();
		
		iphone.pause();
		newIphone.pause();
		
	}
	
	
	
	public String getNumber() {
		return number;
	}



	public void setNumber(String number) {
		this.number = number;
	}



	public Boolean getIsCalling() {
		return isCalling;
	}


	public void setIsCalling(Boolean isCalling) {
		this.isCalling = isCalling;
	}



	public List<String> getMessageList() {
		return messageList;
	}



	public void setMessageList(List<String> messageList) {
		this.messageList = messageList;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getYear() {
		return year;
	}



	public void setYear(String year) {
		this.year = year;
	}



	@Override
	public void play() {
		
		if (this.selectedMusic.isEmpty()) {
		
			System.err.println("\nNenhuma música selecionada!\n");
			return;
		
		}
		
		this.isPlayingMusic = true; 
		System.out.println(this.name + " de " + this.year + " está tocando a música " + this.selectedMusic);
		
	}

	@Override
	public void pause() {
		
		if (this.selectedMusic.isEmpty()) {
			
			System.err.println("\nNenhuma música selecionada!\n");
			return;
		
		}
		
		this.isPlayingMusic = false;
		System.out.println(this.name + " de " + this.year + " pausou a música " + this.selectedMusic);
		
	}
	
	@Override
	public void selectMusic() {

		if (this.musicList.isEmpty()) {
			
			System.err.println("\nNenhuma música salva neste " + this.name + "!\n");
			return;
		}
		
		this.selectedMusic = musicList.get(0);
		System.out.println("Música " + this.selectedMusic + " selecionada!");
		this.play();
		
	}

	@Override
	public void selectMusic(String music) {
		
		if (this.selectedMusic.isEmpty()) {
			
			System.err.println("\nNenhuma música salva neste " + this.name + "!\n");
			return;
		
		}
		
		if (!this.musicList.contains(music)) {
			
			System.err.println("\nA música " + music + " não existe neste " + this.name + "!\n");
			return;	
			
		}
		
		System.out.println("Música " + music + " selecionada!");
		this.selectedMusic = music;
		this.play();
		
	}
	
	@Override
	public void addMusic(String music) {

		if (!this.musicList.contains(music)) {
			
			this.musicList.add(music);
			System.out.println("Música " + music + " adicionada ao " + this.name + " com sucesso!");
			
		} else {
			
			System.err.println("\nMúsica " + music + " já está salva neste "  + this.name + "!\n");
			
		}
		
	}

	@Override
	public void viewSite(String site) {
		
		if (this.tabs > 0) {

			System.out.println("Mostrando a página do site " + site + " no " + this.name);
			this.selectedPage = site;
		
		} else {
			
			System.err.println("\nNão existe janelas abertas neste " + this.name + "!\n");
			
		}
	}
	
	@Override
	public void updatePage() {

		if (this.tabs > 0) {

			System.out.println("Atualizando a página do site " + this.selectedPage + "neste " + this.name);
		}
		else {
				
			System.err.println("\nNão existe janelas abertas neste " + this.name + "!\n");
				
		}
	}


	@Override
	public void addNewTab() {

		if (this.tabs < 2) {
					
			System.out.println("Nova janela adicionada neste "  + this.name);
			tabs += 1;
		} else {
			
			System.err.println("\nMáximo de janelas abertas neste "  + this.name + "!\n");
			
		}
		
		
	}

	@Override
	public void deleteTab() {

		if (this.tabs > 0) {
			
			System.out.println("Janela fechada no "  + this.name);
			this.tabs -= 1;
			
		} else {
			
			System.err.println("\nNão existe janelas abertas neste "  + this.name + "!\n");
			
		}
		
	}
	
	@Override
	public void call(Iphone iphone) {

		if (!this.isCalling) {
			
			if (this.isPlayingMusic) {
				
				this.pause();
				
			}
			
			this.iphoneCalling = iphone;
			System.out.println(this.name + " está ligando para o número " + iphoneCalling.getNumber());
			this.isCalling = true;
			iphone.isCalling = true;
			
		} else {
			
			System.err.println(this.name + " já está em uma ligação!");
			
		}
		
	}
	
	@Override
	public void callOff() {

		if (this.isCalling) {
			
			this.isCalling = false;
			this.iphoneCalling.isCalling = false;
			this.iphoneCalling = null;
			System.out.println("Ligação encerrada no " + this.name);
			
			
		} else {
			
			System.err.println(this.name + " não está em nenhuma ligação!");
			
		}
		
		if (!this.isPlayingMusic && !this.selectedMusic.isEmpty()) {
			
			this.play();
			
		}
		
	}
	

	@Override
	public void answerCall() {
		
		if (this.isPlayingMusic) {
			
			this.pause();
			
		}
		
		if (!this.isCalling) {
			
			System.out.println(this.name + " atendeu a ligação");
			this.isCalling = true;
			
		} else {
			
			System.err.println(this.name + " já está em uma ligação!");
			
		}
		
	}

	@Override
	public void readMessages() {

		
		if (!this.messageList.isEmpty()) {
			
			System.out.println("\nCORREIO DE VOZ\n");
			
			int index = 0;
			
			for(String voiceMail : this.messageList) {
				
				index++;
				
				System.out.println(index + "° - " + voiceMail);
				
			}
			
			this.messageList.clear();
			System.out.println();
			this.play();
		}
		
		
	}
	
	@Override
	public void sendMessage(Iphone iphone, String message) {


		List<String> iphoneMessageList = iphone.getMessageList();
		iphoneMessageList.add(message);
		iphone.setMessageList(iphoneMessageList);
		
		System.out.println("Mensagem enviada de " + this.name + " para " + iphone.getName() + " com sucesso!");		
		
	}


}