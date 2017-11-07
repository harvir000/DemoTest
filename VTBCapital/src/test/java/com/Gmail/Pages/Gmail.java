package com.Gmail.Pages;

import static java.lang.System.out;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Locale;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

public class Gmail {

	public void automateGmailUsingImap(final String USERNAME, final String PASSWORD) {
		Folder folder = null;
		Store store = null;
		System.out.println("***Reading mailbox...");

		try {
			
			Properties props = new Properties();
			props.put("mail.store.protocol", "imaps");
			Session session = Session.getInstance(props);
			store = session.getStore("imaps");
			store.connect("imap.gmail.com", USERNAME, PASSWORD);
			folder = store.getFolder("INBOX");
			folder.open(Folder.READ_ONLY);
			
			Message[] messages = folder.getMessages();
			System.out.println("No of Messages : " + folder.getMessageCount());
			System.out.println("No of Unread Messages : " + folder.getUnreadMessageCount());
			for (int i = 0; i < messages.length - 1; i++) {
				System.out.println("Reading MESSAGE # " + (i + 1) + "...");
				Message msg = messages[i];
				String strMailSubject = "", strMailBody = "";

				// Getting mail subject
				Object subject = msg.getSubject();

				// Getting mail body
				Object content = msg.getContent();

				// Casting objects of mail subject and body into String
				strMailSubject = (String) subject;
				strMailBody = (String) content;

				// Printing mail subject and body
				System.out.println(strMailSubject);
				System.out.println(strMailBody);

				// For debugging get only 10 emails
				 if(i>=9)
				 break;
			}
		} catch (MessagingException messagingException) {
			messagingException.printStackTrace();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		} finally {
			if (folder != null) {
				try {
					folder.close(true);
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			}

			if (store != null) {
				try {
					store.close();
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void check(String host, String storeType, String user, String password) {

		try {

			// create properties field
			Properties properties = new Properties();
			
			properties.put("mail.pop3.host", host);
			properties.put("mail.pop3.port", "995");
			properties.put("mail.pop3.starttls.enable", "true");
			Session emailSession = Session.getDefaultInstance(properties);

			// create the POP3 store object and connect with the pop server
			Store store = emailSession.getStore("pop3s");

			store.connect(host, user, password);

			// create the folder object and open it
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);

			// retrieve the messages from the folder in an array and print it
			Message[] messages = emailFolder.getMessages();
			System.out.println("messages.length---" + messages.length);

			for (int i = 0, n = messages.length; i < n; i++) {
				Message message = messages[i];
				System.out.println("---------------------------------");
				System.out.println("Email Number " + (i + 1));
				System.out.println("Subject: " + message.getSubject());
				System.out.println("From: " + message.getFrom()[0]);
				System.out.println("Text: " + message.getContent().toString());

			}

			// close the store and folder objects
			emailFolder.close(false);
			store.close();

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
//		String host = "pop.gmail.com";
//		String mailStoreType = "pop3";
//		String username = "aggarwalnits5@gmail.com";
//		String password = "Nitish052";
//
//		Gmail obj = new Gmail();
//		// obj.automateGmailUsingImap("aggarwalnits5@gmail.com", "Nitish052");
//
//		obj.check(host, mailStoreType, username, password);
		
		
		
		
		Method allMethods[];
		try {
//			method = Class.forName("java.util.HashMap").getMethod("put", Object.class, Object.class);
			
			allMethods = Class.forName("com.VTB.TestCases.AOPModule").getDeclaredMethods();
			
			for (Method m : allMethods) {
				String mname = m.getName();
				if (!mname.startsWith("TC")) {
				    continue;
				}
		 		Type[] pType = m.getGenericParameterTypes();
		 		if ((pType.length != 1) || Locale.class.isAssignableFrom(pType[0].getClass())) {
		 		    continue;
		 		}

				out.format("invoking %s()%n", mname);
			 }
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
