package fr.esic.javaMiniProjetBase;

import java.util.Random;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class JeuChiffreMagic {

	public static void main(String[] args) {

		// ---------------------------------------------Page d'accueil (Affichage
		// temporaire de bienvenue) --------------------------------------------------

		messageTemporaire(3000,
				"JEU DU CHIFFRE MAGIQUE" + "\n\n\nBienvenue dans le JEU DU CHIFFRE MAGIQUE" + "\n\nChargement...");

		// Pause de 3 secondes pour que le programme puisse continuer
		try {
			Thread.sleep(2999); // Pause de 2999 millisecondes (3 secondes)
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Déclaration de tableau avec 100 lignes et les indices qui repdrésente ID
		// players

		int nbrePlayers = 100;
		int idPlayers = 0;

		// Pseudo base de donnée pour le programme ( nom, alias, mot de passe, catégorie
		// et le score du joueur

		String[] nomUser = new String[nbrePlayers];
		String[] pseudoUser = new String[nbrePlayers];
		String[] mdpUser = new String[nbrePlayers];

		String[] categorieUser = new String[nbrePlayers]; // ------Initialisation de toutes les catégories à E
		for (int i = 0; i < categorieUser.length; i++) {
			categorieUser[i] = "E";
		}

		int[] scoreUser = new int[nbrePlayers]; // ------ tableau score

		// ------ tableau des badges virtuels
		int[] eclat1User = new int[nbrePlayers];
		int[] eclat2User = new int[nbrePlayers];
		int[] eclat3User = new int[nbrePlayers];

		// Variable pour le début et la fin du programme
		String debut = "oui";
		String fin = "";

		// Un boucle pour maintenir le jeu ouvert si on veut changer de
		// joueurs----------------------------
		while (debut == "oui") {

			JOptionPane.showMessageDialog(null, "JEU DU CHIFFRE MAGIQUE une expérience magique");

			// ---------------Variable programme------------------
			String defi = "";
			String niveau = "";
			int connect = 1;

			// -------------------------------------------------------------------------------------------------------------------------Début
			// Inscription

			String choix1 = JOptionPane.showInputDialog("Êtes-vous déjà inscrit ??? (oui / non)");

			choix1 = choix1.toLowerCase();

			// ------ Vérificarion
			while (!choix1.equals("oui") && (!choix1.equals("non"))) {

				choix1 = JOptionPane
						.showInputDialog("Mauvaise saisie veuillez réessayer \nÊtes-vous déjà inscrit ??? (oui / non)");

				choix1 = choix1.toLowerCase();
			}
			// Ajoute d'une condition pour idPlayers càd si c'est un nouveau joueur

			switch (choix1) {
			case "non":
				// ------------------------------------------------------------------------------------------------------------------------------Inscription
				// l'idPayers s'incrémente de 1.
				idPlayers++;

				do {

					nomUser[idPlayers] = JOptionPane.showInputDialog("Veuillez Saisir votre Nom").trim();

					pseudoUser[idPlayers] = JOptionPane.showInputDialog("Veuillez Saisir un Pseudo ( Alias joueur )")
							.trim();

					mdpUser[idPlayers] = JOptionPane.showInputDialog("Veuillez Saisir un Mot de passe");

				} while ((nomUser[idPlayers].isEmpty()) || (pseudoUser[idPlayers].isEmpty())
						|| (mdpUser[idPlayers].isEmpty()));

				JOptionPane.showMessageDialog(null,
						"Inscription reussie ! " + "\n\nIdentifiant : " + idPlayers
								+ "\n( Sauvegarder précisement votre identifiant pour la connexion )" + "\nNom : "
								+ nomUser[idPlayers] + "\nPseudo : " + pseudoUser[idPlayers] + "\nMot de passe : "
								+ mdpUser[idPlayers] + "\n\nAmusez-vous bien !");

				break;

			case "oui":

				JOptionPane.showMessageDialog(null, "Reléver des défis plus fous les uns les autres MAGICIEN");
				break;

			default:
				JOptionPane.showMessageDialog(null,
						"OUP !!! Une erreur est survenue, veuillez svp relancer le programme !");
				break;
			}

			// ---------------------------------------------------------------------------------------------------------------------------------Connexion
			// ---------------------------------

			int c = 1;

			// Vérification ID et mot de passe

			// ---------------------------- Saisir de
			// ID
			String repID; // variable auxiliaire
			repID = JOptionPane.showInputDialog(null,
					"JEU DU CHIFFRE MAGIQUE \nConnectez-vous ... \nSaisissez votre Identifiant");
			String auxID = checkInt(repID); // checkInt fonction pour vérifier si la saisi d'un nombre est bonne

			int jID = 1; // Compteur pour limiter les faux saisies

			while (((auxID != "oui")) && (jID < 3)) { // boucle pour reprendre la saisie

				// checkInt fonction pour vérifier si la saisi d'un nombre est bonne
				repID = JOptionPane.showInputDialog(null,
						"Mauvaise saisie veuillez réessayer \nJEU DU CHIFFRE MAGIQUE \nConnectez-vous ... \nSaisissez votre Identifiant");
				auxID = checkInt(repID);
				jID++;
			}

			// Condition pour sortir du jeu en cas de repetition de mauvaise saisie
			if (((auxID != "oui")) && (jID == 3)) {
				fin = "mal";
				break;
			}

			int id = Integer.parseInt(repID); // Si saisie est bonne conversion de string en int

			String nom = JOptionPane
					.showInputDialog("JEU DU CHIFFRE MAGIQUE \nConnectez-vous ... \nSaisissez votre Nom");
			String pseudo = JOptionPane
					.showInputDialog("JEU DU CHIFFRE MAGIQUE \nConnectez-vous ... \nSaisissez votre Pseudo");
			String mdp = JOptionPane
					.showInputDialog("JEU DU CHIFFRE MAGIQUE \nConnectez-vous ... \nSaisissez votre Mot de passe");

			while (((!nom.equals(nomUser[id])) || (!pseudo.equals(pseudoUser[id])) || (!mdp.equals(mdpUser[id])))
					&& (c < 3)) { // Pour vérifier si la saisie est bonne

				repID = JOptionPane.showInputDialog(
						"Identifiant, Nom, Pseudo ou Mot de passe incorrect !!! \nSaisissez votre identifiant");
				auxID = checkInt(repID); // checkInt fonction pour vérifier si la saisi d'un nombre est bonne
				if (auxID != "oui") {
					id = 0;
				} else {
					id = Integer.parseInt(repID);
				}

				nom = JOptionPane.showInputDialog("JEU DU CHIFFRE MAGIQUE \nConnectez-vous ... \nSaisissez votre Nom");
				pseudo = JOptionPane
						.showInputDialog("JEU DU CHIFFRE MAGIQUE \nConnectez-vous ... \nSaisissez votre Pseudo");
				mdp = JOptionPane
						.showInputDialog("JEU DU CHIFFRE MAGIQUE \nConnectez-vous ... \nSaisissez votre Mot de passe");

				c++;
			}

			// -------------------------------------------- Compte bloqué
			// -----------------------------------------------------------------

			if ((c == 3)
					&& ((!nom.equals(nomUser[id])) || (!pseudo.equals(pseudoUser[id])) || (!mdp.equals(mdpUser[id])))) {

				JOptionPane.showMessageDialog(null, "Compte bloqué. Contactez le support");
				break;
			}

			// -----------------------------------------------------------------------------------------------------------------------------
			// Début du jeu
			else {
				// ------------------------------------ Message de bienvenue
				// ---------------------------------------------------------------

				JOptionPane.showMessageDialog(null, "Bienvenue " + pseudoUser[id]);

				// Boucle pour mainntenir la connexion au jeu ----------
				while (connect == 1) {

					// --------------------------------------------------------------------------------------------------------------------
					// Connectez au jeu
					// Vérification du score pour attribuer la catégorie à laquelle il appartient
					if (scoreUser[id] < 1) {
						categorieUser[id] = "E";
					} else if (scoreUser[id] < 2) {
						categorieUser[id] = "D";
					} else if (scoreUser[id] < 3) {
						categorieUser[id] = "C";
					} else if (scoreUser[id] < 4) {
						categorieUser[id] = "B";
					} else if (scoreUser[id] >= 300) {
						categorieUser[id] = "S";
					} else {
						categorieUser[id] = "A";
					}

					JOptionPane.showMessageDialog(null,
							"Profil : " + pseudoUser[id] + "\n\nCatégorie : " + categorieUser[id] + "\nScore : "
									+ scoreUser[id] + "\nCoup d'Eclat : " + eclat1User[id] + "\nCoup de Génie : "
									+ eclat2User[id] + "\nCoup de Maître : " + eclat3User[id]);

					defi = JOptionPane.showInputDialog("Lancer un défi ? (oui / non)");
					defi = defi.toLowerCase();

					// ------ Vérification défi
					while (!defi.equals("oui") && (!defi.equals("non"))) {
						defi = JOptionPane
								.showInputDialog("Mauvaise saisie veuillez réessayer \nLancer un défi ? (oui / non)");
						defi = defi.toLowerCase();
					} // fin while

					// ---------------------------------------------------------------------------------------------------------------------défi
					switch (defi) {
					case "non":
						String deconnect;

						// Voulez-vous vous déconnecter ???
						deconnect = JOptionPane.showInputDialog("Voulez-vous vous déconnecter ? (oui / non)");
						deconnect = deconnect.toLowerCase();

						// ------ Vérification défi
						while (!deconnect.equals("oui") && (!deconnect.equals("non"))) {
							deconnect = JOptionPane.showInputDialog(
									"Mauvaise saisie veuillez réessayer \nVoulez-vous vous déconnecter ? (oui / non)");
							deconnect = deconnect.toLowerCase();
						} // fin while

						// ------------------------------------------------------------------------------------------------------------------Déconnecter
						switch (deconnect) {
						case "non":
							connect = 1;
							break;
						case "oui":
							connect = 0;
							break;
						default:
							JOptionPane.showMessageDialog(null,
									"OUP !!! Une erreur est survenue, veuillez svp relancer le programme !");
							break;
						} // fin Déconnecter

						break;

					case "oui":

						if ((categorieUser[id].equals("S")) || (categorieUser[id].equals("A"))) {

							niveau = JOptionPane.showInputDialog(
									"Saisissez le numéro de défi : " + "\n1- Niv. Facile" + "\n2- Niv. Normal"
											+ "\n3- Niv. Moyen" + "\n4- Niv. Difficile" + "\n5- Niv. Arcade");
							niveau = niveau.toLowerCase();

							// ----- Vérification choix niveau
							while ((!niveau.equals("1")) && (!niveau.equals("2")) && (!niveau.equals("3"))
									&& (!niveau.equals("4")) && (!niveau.equals("5"))) {

								niveau = JOptionPane.showInputDialog("Mauvaise saisie veuillez réessayer \n"
										+ "Saisissez le numéro du niveau : " + "\n1- Niv. Facile" + "\n2- Niv. Normal"
										+ "\n3- Niv. Moyen" + "\n4- Niv. Difficile" + "\n5- Niv. Arcade");
								niveau = niveau.toLowerCase();
							} // fin while

						} // fin if

						else if ((categorieUser[id].equals("B")) || (categorieUser[id].equals("C"))) {

							niveau = JOptionPane.showInputDialog("Saisissez le numéro de défi : " + "\n1- Niv. Facile"
									+ "\n2- Niv. Normal" + "\n3- Niv. Moyen" + "\n4- Niv. Difficile");
							niveau = niveau.toLowerCase();

							// ----- Vérification choix niveau
							while (!niveau.equals("1") && (!niveau.equals("2")) && (!niveau.equals("3"))
									&& (!niveau.equals("4"))) {

								niveau = JOptionPane.showInputDialog("Mauvaise saisie veuillez réessayer \n"
										+ "Saisissez le numéro du niveau : " + "\n1- Niv. Facile" + "\n2- Niv. Normal"
										+ "\n3- Niv. Moyen" + "\n4- Niv. Difficile");
								niveau = niveau.toLowerCase();
							} // fin while

						} // fin else if

						else {

							niveau = JOptionPane.showInputDialog(
									"Saisissez le numéro de défi : " + "\n1- Niv. Facile" + "\n2- Niv. Normal");
							niveau = niveau.toLowerCase();

							// ----- Vérification choix niveau
							while (!niveau.equals("1") && (!niveau.equals("2"))) {

								niveau = JOptionPane.showInputDialog("Mauvaise saisie veuillez réessayer \n"
										+ "Saisissez le numéro du niveau : " + "\n1- Niv. Facile" + "\n2- Niv. Normal");
								niveau = niveau.toLowerCase();
							} // fin while
						} // fin else

						JOptionPane.showMessageDialog(null, " Niveau " + niveau);

						switch (niveau) {

						case "1": // -----------------------------------------------------------------------------------------------------
									// Niveau Facile

							JOptionPane.showMessageDialog(null, "Démarrage Niveau Facile...");

							// Variable niveau facile

							int minF = 1, maxF = 20;
							int aleaF = nbreRandom(minF, maxF);
							String auxF = "", repF = "";

							Boolean reponseF;

							// Génération d'un nombre aléatoire entre 0 et 5 inclus
							int f = 0;
							do {
								f++;
								repF = JOptionPane.showInputDialog(null,
										"Question : deviner un nombre entre " + minF + " et " + maxF);

								auxF = checkInt(repF); // checkInt fonction pour vérifier si la saisi d'un nombre est
														// bonne

								int j = 1;

								while (((auxF != "oui")) && (j < 3)) {

									// checkInt fonction pour vérifier si la saisi d'un nombre est bonne
									repF = JOptionPane.showInputDialog(null, "Mauvaise saisie veuillez réessayer "
											+ "Question : deviner un nombre entre " + minF + " et " + maxF);
									auxF = checkInt(repF);
									j++;
								}

								if ((j == 3) && (auxF != "oui")) {

									JOptionPane.showMessageDialog(null,
											"Trop d'erreur de saisi, veuillez relancer le défi");
									// connect = "rouge"; si je veux sortir du jeu
									break;
								} else {
									reponseF = nbreVerify(aleaF, Integer.parseInt(repF)); // conversion de repF en
																							// integer
								}

								if (reponseF) {

									if (f == 1) {
										JOptionPane.showMessageDialog(null,
												"Wahou en plein dans le mille!" + "\nCoup d'éclat " + "\nBonus +1pt ");
										eclat1User[id]++;
									} // fin if
									else {
										JOptionPane.showMessageDialog(null, "Bonne réponse ! ");

									}
								} // fin if
								else {
									JOptionPane.showMessageDialog(null, msgPetitGrand(aleaF, Integer.parseInt(repF)));
								}

							} while (!reponseF);// fin pour du jeu facile

							if ((f == 1)) {
								scoreUser[id] += 3;
							} else if ((f == 2) || (f == 3)) {
								scoreUser[id] += 2;
							} else if ((f == 4) || (f == 5)) {
								scoreUser[id]++;
							} else {
								scoreUser[id] += 0;
							}

							JOptionPane.showMessageDialog(null, "Fin du défis...");

							break;

						case "2": // ----------------------------------------------------------------------------------------------------------
									// Niveau normal
							JOptionPane.showMessageDialog(null, "Démarrage Niveau Normal...");

							// Variable niveau Normal

							int minN = 1, maxN = 20;
							int aleaN = nbreRandom(minN, maxN);
							String auxN = "", repN = "";

							Boolean reponseN;

							// Génération d'un nombre aléatoire entre 0 et 5 inclus
							int n = 0;
							do {
								n++;

								repN = JOptionPane.showInputDialog(null,
										"Question : deviner un nombre entre " + minN + " et " + maxN);

								auxN = checkInt(repN); // checkInt fonction pour vérifier si la saisi d'un nombre est
														// bonne

								int j = 1;

								while (((auxN != "oui")) && (j < 3)) {

									// checkInt fonction pour vérifier si la saisi d'un nombre est bonne
									repN = JOptionPane.showInputDialog(null, "Mauvaise saisie veuillez réessayer "
											+ "Question : deviner un nombre entre " + minN + " et " + maxN);
									auxN = checkInt(repN);
									j++;
								}

								if ((j == 3) && (auxN != "oui")) {

									JOptionPane.showMessageDialog(null,
											"Trop d'erreur de saisi, veuillez relancer le défi");
									// connect = "rouge"; si je veux sortir du jeu
									break;
								} else {
									reponseN = nbreVerify(aleaN, Integer.parseInt(repN)); // conversion de repN en
																							// integer
								}

								if (reponseN) {

									if (n == 1) {
										JOptionPane.showMessageDialog(null,
												"Wahou en plein dans le mille!" + "\nCoup d'éclat " + "\nBonus +1pt ");
										eclat1User[id]++;
									} // fin if
									else {
										JOptionPane.showMessageDialog(null, "Bonne réponse ! ");
									}
									break;
								} // fin if
								else {
									JOptionPane.showMessageDialog(null, msgPetitGrand(aleaN, Integer.parseInt(repN)));
								}

							} while (!reponseN || (n < 5));

							if ((n == 1)) {
								scoreUser[id] += 4;
							} else if ((n == 2)) {
								scoreUser[id] += 2;
							} else if ((n == 3)) {
								scoreUser[id]++;
							} else {
								scoreUser[id] += 0;
							}

							JOptionPane.showMessageDialog(null, "Fin du défis...");

							break;

						case "3": // -----------------------------------------------------------------------------------------------------------
									// Niveau moyen
							JOptionPane.showMessageDialog(null, "Démarrage Niveau Moyen...");

							// Variable niveau moyen

							int minM = 1, maxM = 20;
							String auxM = "", repM = "";
							int succesM = 0;
							Boolean reponseM;

							// Génération d'un nombre aléatoire entre 0 et 5 inclus
							int m1 = 0;
							do {
								m1++;
								int aleaM = nbreRandom(minM, maxM);
								for (int m = 1; m < 6; m++) {

									repM = JOptionPane.showInputDialog(null,
											"Question : deviner un nombre entre " + minM + " et " + maxM);

									auxM = checkInt(repM); // checkInt fonction pour vérifier si la saisi d'un nombre
															// est
															// bonne

									int j = 1;

									while (((auxM != "oui")) && (j < 3)) {

										// checkInt fonction pour vérifier si la saisi d'un nombre est bonne
										repM = JOptionPane.showInputDialog(null, "Mauvaise saisie veuillez réessayer "
												+ "Question : deviner un nombre entre " + minM + " et " + maxM);
										auxM = checkInt(repM);
										j++;
									}

									if ((j == 3) && (auxM != "oui")) {

										JOptionPane.showMessageDialog(null,
												"Trop d'erreur de saisi, veuillez relancer le défi");
										// connect = "rouge"; si je veux sortir du jeu
										break;
									} else {
										reponseM = nbreVerify(aleaM, Integer.parseInt(repM)); // conversion de repF en
																								// integer
									}

									if (reponseM) {
										succesM++;
										maxM += 5; // On augmente l'intervalle
										if (m == 1) {
											JOptionPane.showMessageDialog(null, "Wahou en plein dans le mille!"
													+ "\nCoup de Génie " + "\nBonus +2pt ");

											eclat2User[id]++;
										} // fin if
										else {
											JOptionPane.showMessageDialog(null, "Bonne réponse ! ");
										}
										break;
									} // fin if
									else {
										JOptionPane.showMessageDialog(null,
												msgPetitGrand(aleaM, Integer.parseInt(repM)));
									}

								} // fin pour du jeu Moyen


							} while (m1 < 5);
							if ((succesM == 1)) {
								scoreUser[id] += 5;
							} else if ((succesM == 2)) {
								scoreUser[id] += 2;
							} else if ((succesM == 3)) {
								scoreUser[id]++;
							} else {
								scoreUser[id] += 0;
							}

							JOptionPane.showMessageDialog(null, "Fin du défis...");
							break;

						case "4": // ------------------------------------------------- Niveau Difficile
							JOptionPane.showMessageDialog(null, "Démarrage Niveau Difficile...");

							// Variable niveau facile
							int minD = 1, maxD = 20;
							String auxD = "", repD = "";
							int succesD = 0;
							Boolean reponseD;

							// Génération d'un nombre aléatoire entre 0 et 5 inclus
							int d1 = 0;
							do {
								d1++;
								for (int d = 1; d < 6; d++) {

									repD = JOptionPane.showInputDialog(null,
											"Question : deviner un nombre entre " + minD + " et " + maxD);

									int aleaD = nbreRandom(minD, maxD);
									auxD = checkInt(repD); // checkInt fonction pour vérifier si la saisi d'un nombre
															// est
															// bonne

									int j = 1;

									while (((auxD != "oui")) && (j < 3)) {

										// checkInt fonction pour vérifier si la saisi d'un nombre est bonne
										repD = JOptionPane.showInputDialog(null, "Mauvaise saisie veuillez réessayer "
												+ "Question : deviner un nombre entre " + minD + " et " + maxD);
										auxD = checkInt(repD);
										j++;
									}

									if ((j == 3) && (auxD != "oui")) {

										JOptionPane.showMessageDialog(null,
												"Trop d'erreur de saisi, veuillez relancer le défi");
										// connect = "rouge"; si je veux sortir du jeu
										break;
									} else {
										reponseD = nbreVerify(aleaD, Integer.parseInt(repD)); // conversion de repF en
																								// integer
									}

									if (reponseD) {
										succesD++;
										if (succesD == 5) {
											JOptionPane.showMessageDialog(null, "Wahou en plein dans le mille!"
													+ "\nCoup de Génie " + "\nBonus +2pt ");
											eclat2User[id]++;
										} // fin if
										else {
											JOptionPane.showMessageDialog(null, "Bonne réponse ! ");

										}
										break;
									} // fin if
									else {
										JOptionPane.showMessageDialog(null,
												msgPetitGrand(aleaD, Integer.parseInt(repD)));
									}

								} // fin pour du jeu Moyen


							} while (d1 < 5);
							if ((succesD == 1)) {
								scoreUser[id] += 5;
							} else if ((succesD == 2)) {
								scoreUser[id] += 2;
							} else if ((succesD == 3)) {
								scoreUser[id]++;
							} else {
								scoreUser[id] += 0;
							}

							JOptionPane.showMessageDialog(null, "Fin du défis...");

							break;

						case "5": // ----------------------------------------------------- Niveau Arcade

							JOptionPane.showMessageDialog(null, "Arcade !");

							// Variable niveau facile
							int minP = 0, maxP = 0;
							String auxPmin, auxPmax, repPmin, repPmax;
							String auxP = "", repP = "";
							int succesP = 0;
							Boolean reponseP;

							// Génération d'un nombre aléatoire entre 0 et 5 inclus
							int p1 = 0;

							do {
								p1++;

								// _-------------
								do {
									JOptionPane.showMessageDialog(null,
											"Donner un intervalle d'amplitude 30 ( au moins 30 unités entre min et max");

									repPmin = JOptionPane.showInputDialog(null,
											"Donner le nombre min de l'intervalle ");

									auxPmin = checkInt(repPmin); // checkInt fonction pour vérifier si la saisi d'un
																	// nombre est
									// bonne
									int j = 1;

									while (((auxPmin != "oui")) && (j < 3)) {

										// checkInt fonction pour vérifier si la saisi d'un nombre est bonne
										repPmin = JOptionPane.showInputDialog(null,
												"Mauvaise saisie veuillez réessayer "
														+ "Donner le nombre min de l'intervalle ");
										auxPmin = checkInt(repPmin);
										j++;
									}

									if ((j == 3) && (auxPmin != "oui")) {

										JOptionPane.showMessageDialog(null,
												"Trop d'erreur de saisi, veuillez relancer le défi");
										// connect = "rouge"; si je veux sortir du jeu
										break;
									} else {
										minP = Integer.parseInt(repPmin); // conversion de repF en integer
									}

									repPmax = JOptionPane.showInputDialog(null,
											"Donner le nombre max de l'intervalle ");

									auxPmax = checkInt(repPmax); // checkInt fonction pour vérifier si la saisi d'un
																	// nombre est
									// bonne
									j = 1;

									while (((auxPmax != "oui")) && (j < 3)) {

										// checkInt fonction pour vérifier si la saisi d'un nombre est bonne
										repPmax = JOptionPane.showInputDialog(null,
												"Mauvaise saisie veuillez réessayer "
														+ "Donner le nombre max de l'intervalle ");
										auxPmax = checkInt(repPmax);
										j++;
									}

									if ((j == 3) && (auxPmax != "oui")) {

										JOptionPane.showMessageDialog(null,
												"Trop d'erreur de saisi, veuillez relancer le défi");
										// connect = "rouge"; si je veux sortir du jeu
										break;
									} else {
										maxP = Integer.parseInt(repPmax); // conversion de repF en integer
									}

								} while (Math.abs(minP - maxP) < 30 || (minP > maxP));

								int aleaP = nbreRandom(minP, maxP);

								for (int p = 1; p < 6; p++) {

									// _------------

									repP = JOptionPane.showInputDialog(null,
											"Question : deviner un nombre entre " + minP + " et " + maxP);

									auxP = checkInt(repP); // checkInt fonction pour vérifier si la saisi d'un nombre
															// est
															// bonne

									int j = 1;

									while (((auxP != "oui")) && (j < 3)) {

										// checkInt fonction pour vérifier si la saisi d'un nombre est bonne
										repP = JOptionPane.showInputDialog(null, "Mauvaise saisie veuillez réessayer "
												+ "Question : deviner un nombre entre " + minP + " et " + maxP);
										auxP = checkInt(repP);
										j++;
									}

									if ((j == 3) && (auxP != "oui")) {

										JOptionPane.showMessageDialog(null,
												"Trop d'erreur de saisi, veuillez relancer le défi");
										// connect = "rouge"; si je veux sortir du jeu
										break;
									} else {
										reponseP = nbreVerify(aleaP, Integer.parseInt(repP)); // conversion de repF en
																								// integer
									}

									if (reponseP) {
										succesP++;
										if (p == 1) {
											JOptionPane.showMessageDialog(null, "Wahou en plein dans le mille!"
													+ "\nCoup de Maître " + "\nBonus +3pt ");
											eclat3User[id]++;
										} // fin if
										else {
											JOptionPane.showMessageDialog(null, "Bonne réponse ! ");

										}
									} // fin if
									else {
										JOptionPane.showMessageDialog(null,
												msgPetitGrand(aleaP, Integer.parseInt(repP)));
									}

								} // fin pour du jeu Moyen


							} while (p1 < 5);
							if ((succesP == 1)) {
								scoreUser[id] += 7;
							} else if ((succesP == 2)) {
								scoreUser[id] += 3;
							} else if ((succesP == 3)) {
								scoreUser[id]++;
							} else {
								scoreUser[id] += 0;
							}

							JOptionPane.showMessageDialog(null, "Fin du défis...");

							break;

						default:
							JOptionPane.showMessageDialog(null,
									"OUP !!! Une erreur est survenue, veuillez svp relancer le programme !");
							break;
						}
						break;
					default:
						JOptionPane.showMessageDialog(null,
								"OUP !!! Une erreur est survenue, veuillez svp relancer le programme !");
						break;

					} // fin switch.
						// -----------------------------------------------------------------------------------------------------fin
						// défi

				} // fin while.
					// ---------------------------------------------------------------------------------------------------------fin
					// connexion

			} // fin else.
				// --------------------------------------------------------------------------------------------------------------fin
				// déconnecxion

			// Afficher fermer l'application
			String deb = "";
			deb = JOptionPane.showInputDialog("Voulez-vous vous quitter le jeu ? (oui / non)");
			deb = deb.toLowerCase();

			// ------ Vérification saisie quitter le jeu
			while (!deb.equals("oui") && (!deb.equals("non"))) {
				deb = JOptionPane.showInputDialog(
						"Mauvaise saisie veuillez réessayer \nVoulez-vous vous quitter le jeu ? (oui / non)");
				deb = deb.toLowerCase();
			} // fin while

			switch (deb) {
			case "non":
				debut = "oui";
				break;
			case "oui":
				debut = "non";
				break;
			default:
				JOptionPane.showMessageDialog(null,
						"OUP !!! Une erreur est survenue, veuillez svp relancer le programme !");
				break;
			}
		}

		if (fin == "mal") {
			JOptionPane.showMessageDialog(null,
					"OUP !!! Plusieurs erreurs de saisie. Veuillez svp relancer le programme !");
		} else {
			JOptionPane.showMessageDialog(null, "Merci d'avoir participé au JEU DE CALCUL ");
		}

	}

	// Fonctions et procédure

	// Fonction ppour générer un nombre aléatoire
	public static int nbreRandom(int min, int max) {
		Random rand = new Random();
		return rand.nextInt((max - min) + 1) + min;
	}

	// Fonction pour vérifier si deux nombres sont égaux
	public static Boolean nbreVerify(int nRand, int nbre) {
		if (nRand == nbre) {
			return true;
		}
		return false;
	}

	public static String msgPetitGrand(int aRand, int bNbre) {
		if (bNbre > aRand) {
			return "Vous êtes plus haut !";
		} else if (bNbre < aRand) {
			return "Vous êtes plus bas !";
		}
		return "Bravo !";
	}

	// Fonction pour vérifier un nombre entier ou double
	public static String checkInt(String check) {

		if (check.isEmpty()) {
			return "non";
		}
		for (int i = 0; i < check.length(); i++) {

			if ((check.charAt(i) == '1') || (check.charAt(i) == '2') || (check.charAt(i) == '3')
					|| (check.charAt(i) == '4') || (check.charAt(i) == '5') || (check.charAt(i) == '6')
					|| (check.charAt(i) == '7') || (check.charAt(i) == '8') || (check.charAt(i) == '9')
					|| (check.charAt(i) == '0') || ((check.charAt(i) == '-') && (i == 0))) {
			} else {
				return "non";
			}
		}
		return "oui";
	}

	// Procédure pour afficher un message pour à l'ecran pour un temps précis
	public static void messageTemporaire(int temps, String message) {

		JOptionPane pane = new JOptionPane(message, JOptionPane.PLAIN_MESSAGE);
		final JOptionPane optionPane = new JOptionPane();
		optionPane.setMessage(pane.getMessage());
		optionPane.setMessageType(JOptionPane.PLAIN_MESSAGE);

		final JDialog dialog = optionPane.createDialog(null, "Message");
		dialog.setModal(false);
		dialog.setVisible(true);

		// Créer un timer pour fermer automatiquement la boîte de dialogue après le
		// temps spécifié
		Timer timer = new Timer(temps, e -> {
			dialog.setVisible(false);
			dialog.dispose();
		});
		timer.setRepeats(false);
		timer.start();
	}

}
