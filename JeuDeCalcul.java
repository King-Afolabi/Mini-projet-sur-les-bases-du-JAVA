package fr.esic.javaMiniProjetBase;

import javax.swing.JOptionPane;
import javax.swing.JDialog;

import java.util.Random;
import javax.swing.Timer;

public class JeuDeCalcul {
	

	public static void main(String[] args) {

		// ---------------------------------------------Page d'accueil (Affichage
		// temporaire de bienvenue) --------------------------------------------------

		messageTemporaire(3000, "JEU DE CALCUL" + "\n\n\nBienvenue dans le JEU DE CALCUL" + "\n\nChargement...");

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

			JOptionPane.showMessageDialog(null, "JEU DE CALCUL une expérience hors du commun");

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

				JOptionPane.showMessageDialog(null, "Reléver des défis plus fous les uns les autres CALCULEUR");
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
					"JEU DE CALCUL \nConnectez-vous ... \nSaisissez votre Identifiant");
			String auxID = checkInt(repID); // checkInt fonction pour vérifier si la saisi d'un nombre est bonne

			int jID = 1; // Compteur pour limiter les faux saisies

			while (((auxID != "oui")) && (jID < 3)) { // boucle pour reprendre la saisie

				// checkInt fonction pour vérifier si la saisi d'un nombre est bonne
				repID = JOptionPane.showInputDialog(null,
						"Mauvaise saisie veuillez réessayer \nJEU DE CALCUL \nConnectez-vous ... \nSaisissez votre Identifiant");
				auxID = checkInt(repID);
				jID++;
			}

			// Condition pour sortir du jeu en cas de repetition de mauvaise saisie
			if (((auxID != "oui")) && (jID == 3)) {
				fin = "mal";
				break;
			}

			int id = Integer.parseInt(repID); // Si saisie est bonne conversion de string en int

			String nom = JOptionPane.showInputDialog("JEU DE CALCUL \nConnectez-vous ... \nSaisissez votre Nom");
			String pseudo = JOptionPane.showInputDialog("JEU DE CALCUL \nConnectez-vous ... \nSaisissez votre Pseudo");
			String mdp = JOptionPane
					.showInputDialog("JEU DE CALCUL \nConnectez-vous ... \nSaisissez votre Mot de passe");

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

				nom = JOptionPane.showInputDialog("JEU DE CALCUL \nConnectez-vous ... \nSaisissez votre Nom");
				pseudo = JOptionPane.showInputDialog("JEU DE CALCUL \nConnectez-vous ... \nSaisissez votre Pseudo");
				mdp = JOptionPane.showInputDialog("JEU DE CALCUL \nConnectez-vous ... \nSaisissez votre Mot de passe");

				c++;
			}

			// -------------------------------------------- Compte bloqué -----------------------------------------------------------------

			if ((c == 3)
					&& ((!nom.equals(nomUser[id])) || (!pseudo.equals(pseudoUser[id])) || (!mdp.equals(mdpUser[id])))) {

				JOptionPane.showMessageDialog(null, "Compte bloqué. Contactez le support");
				break;
			}

			// ----------------------------------------------------------------------------------------------------------------------------- Début du jeu
			else {
				// ------------------------------------ Message de bienvenue ---------------------------------------------------------------

				JOptionPane.showMessageDialog(null, "Bienvenue " + pseudoUser[id]);

				// Boucle pour mainntenir la connexion au jeu ----------
				while (connect == 1) {

					// -------------------------------------------------------------------------------------------------------------------- Connectez au jeu
					// Vérification du score pour attribuer la catégorie à laquelle il appartient
					if (scoreUser[id] < 12) {
						categorieUser[id] = "E";
					} else if (scoreUser[id] < 18) {
						categorieUser[id] = "D";
					} else if (scoreUser[id] < 36) {
						categorieUser[id] = "C";
					} else if (scoreUser[id] < 72) {
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

						case "1": // ----------------------------------------------------------------------------------------------------- Niveau Facile

							JOptionPane.showMessageDialog(null, "Démarrage Niveau Facile...");

							// Variable niveau facile
							int alea1F = 0, alea2F = 0, resultF = 0, reponseF = 0;
							String auxF = "", repF = "";

							int succesF = 0;

							// Génération d'un nombre aléatoire entre 0 et 5 inclus

							for (int f = 1; f < 6; f++) {

								Random randF = new Random();
								alea1F = randF.nextInt(6);
								alea2F = randF.nextInt(6);
								resultF = alea1F + alea2F;

								repF = JOptionPane.showInputDialog(null,
										"Question " + f + "\nCombien font " + alea1F + " + " + alea2F + " ?");

								auxF = checkInt(repF); // checkInt fonction pour vérifier si la saisi d'un nombre est
														// bonne

								int j = 1;

								while (((auxF != "oui")) && (j < 3)) {

									// checkInt fonction pour vérifier si la saisi d'un nombre est bonne
									repF = JOptionPane.showInputDialog(null, "Mauvaise saisie veuillez réessayer "
											+ "Question " + f + "\nCombien font " + alea1F + " + " + alea2F + " ?");
									auxF = checkInt(repF);
									j++;
								}

								if ((j == 3) && (auxF != "oui")) {

									JOptionPane.showMessageDialog(null,
											"Trop d'erreur de saisi, veuillez relancer le défi");
									// connect = "rouge"; si je veux sortir du jeu
									break;
								} else {
									reponseF = Integer.parseInt(repF); // conversion de repF en integer
								}

								if (reponseF == resultF) {
									succesF++;
									if (succesF == 5) {
										JOptionPane.showMessageDialog(null,
												"Wahou !" + "\nCoup d'éclat " + "\nBonus +1pt " + succesF + "/" + f);
										eclat1User[id]++;
									} // fin if
									else {
										JOptionPane.showMessageDialog(null, "Bonne réponse ! " + succesF + "/" + f);

									}
								} // fin if
								else {
									JOptionPane.showMessageDialog(null, "Poto !");
								}

							} // fin pour du jeu facile

							if ((succesF == 3) || (succesF == 4)) {
								scoreUser[id] += 2;
							} else if ((succesF == 5)) {
								scoreUser[id] += 3;
							} else if ((succesF <= 1)) {
								scoreUser[id]--;
							} else {
								scoreUser[id] += 0;
							}

							JOptionPane.showMessageDialog(null, "Fin du défis...");

							break;

						case "2": // ---------------------------------------------------------------------------------------------------------- Niveau normal
							JOptionPane.showMessageDialog(null, "Démarrage Niveau Normal...");

							// Variable niveau Normal
							int alea1N = 0, alea2N = 0, resultN = 0, reponseN = 0;
							String auxN = "", repN = "";

							int succesN = 0;

							// Génération d'un nombre aléatoire entre 0 et 7

							for (int n = 1; n < 6; n++) {

								Random randN = new Random();
								alea1N = randN.nextInt(15) - 7;
								alea2N = randN.nextInt(15) - 7;
								resultN = alea1N + alea2N;

								repN = JOptionPane.showInputDialog(null,
										"Question " + n + "\nCombien font " + alea1N + " + " + alea2N + " ?");

								auxN = checkInt(repN); // checkInt fonction pour vérifier si la saisi d'un nombre est
														// bonne

								int j = 1;

								while (((auxN != "oui")) && (j < 3)) {

									// checkInt fonction pour vérifier si la saisi d'un nombre est bonne
									repN = JOptionPane.showInputDialog(null, "Mauvaise saisie veuillez réessayer "
											+ "Question " + n + "\nCombien font " + alea1N + " + " + alea2N + " ?");
									auxN = checkInt(repN);
									j++;
								}

								if ((j == 3) && (auxN != "oui")) {

									JOptionPane.showMessageDialog(null,
											"Trop d'erreur de saisi, veuillez relancer le défi");
									// connect = "rouge"; si je veux sortir du jeu
									break;
								} else {
									reponseN = Integer.parseInt(repN); // conversion de repF en integer
								}

								if (reponseN == resultN) {
									succesN++;
									if (succesN == 5) {
										JOptionPane.showMessageDialog(null,
												"Wahou !" + "\nCoup d'éclat " + "\nBonus +1pt " + succesN + "/" + n);
										eclat1User[id]++;
									} // fin if
									else {
										JOptionPane.showMessageDialog(null, "Bonne réponse ! " + succesN + "/" + n);

									}
								} // fin if
								else {
									
									JOptionPane.showMessageDialog(null, "Poto !");
								}

							} // fin pour du jeu normal

							if ((succesN == 3) || (succesN == 4)) {
								scoreUser[id] += 2;
							} else if ((succesN == 5)) {
								scoreUser[id] += 3;
							} else if ((succesN <= 1)) {
								scoreUser[id]--;
							} else {
								scoreUser[id] += 0;
							}

							JOptionPane.showMessageDialog(null, "Fin du défis...");

							break;

						case "3": // ----------------------------------------------------------------------------------------------------------- Niveau moyen
							JOptionPane.showMessageDialog(null, "Démarrage Niveau Moyen...");

							// Variable niveau moyen
							int alea1M = 0, alea2M = 0, aleaCalculM = 0, resultM = 0, reponseM = 0;
							String auxM = "", repM = "";

							int succesM = 0;

							// Génération d'un nombre aléatoire entre 0 et 5 inclus

							for (int m = 1; m < 8; m++) {

								Random randM = new Random();

								aleaCalculM = randM.nextInt(3);
								alea1M = randM.nextInt(31) - 15;
								alea2M = randM.nextInt(31) - 15;

								switch (aleaCalculM) {
								case 0:
									// ------- Somme
									resultM = alea1M + alea2M;

									repM = JOptionPane.showInputDialog(null,
											"Question " + m + "\nCombien font " + alea1M + " + (" + alea2M + ") ?");

									auxM = checkInt(repM); // checkInt fonction pour vérifier si la saisi d'un nombre
															// est
															// bonne

									int j = 1;

									while (((auxM != "oui")) && (j < 3)) {

										// checkInt fonction pour vérifier si la saisi d'un nombre est bonne

										repM = JOptionPane.showInputDialog(null,
												"Mauvaise saisie veuillez réessayer " + "Question " + m
														+ "\nCombien font " + alea1M + " + (" + alea2M + ") ?");
										auxM = checkInt(repM);
										j++;
									}

									if ((j == 3) && (auxM != "oui")) {

										JOptionPane.showMessageDialog(null,
												"Trop d'erreur de saisi, veuillez relancer le défi");
										// connect = "rouge"; si je veux sortir du jeu
										break;
									} else {
										reponseM = Integer.parseInt(repM); // conversion de repF en integer
									}

									if (reponseM == resultM) {
										succesM++;
										if (succesM == 7) {
											JOptionPane.showMessageDialog(null, "Wahou !" + "\nCoup de Génie "
													+ "\nBonus +2pt " + succesM + "/" + m);
											eclat2User[id]++;
										} // fin if
										else {
											JOptionPane.showMessageDialog(null, "Bonne réponse ! " + succesM + "/" + m);

										}
									} // fin if
									else {
										
										JOptionPane.showMessageDialog(null, "Poto !");
									}

									break;

								case 1:
									// ------- soustration

									resultM = alea1M - alea2M;

									repM = JOptionPane.showInputDialog(null,
											"Question " + m + "\nCombien font " + alea1M + " - (" + alea2M + ") ?");

									auxM = checkInt(repM); // checkInt fonction pour vérifier si la saisi d'un nombre
															// est
															// bonne

									j = 1;

									while (((auxM != "oui")) && (j < 3)) {

										// checkInt fonction pour vérifier si la saisi d'un nombre est bonne

										repM = JOptionPane.showInputDialog(null,
												"Mauvaise saisie veuillez réessayer " + "Question " + m
														+ "\nCombien font " + alea1M + " - (" + alea2M + ") ?");
										auxM = checkInt(repM);
										j++;
									}

									if ((j == 3) && (auxM != "oui")) {

										JOptionPane.showMessageDialog(null,
												"Trop d'erreur de saisi, veuillez relancer le défi");
										// connect = "rouge"; si je veux sortir du jeu
										break;
									} else {
										reponseM = Integer.parseInt(repM); // conversion de repF en integer
									}

									if (reponseM == resultM) {
										succesM++;
										if (succesM == 7) {
											JOptionPane.showMessageDialog(null, "Wahou !" + "\nCoup de Génie "
													+ "\nBonus +2pt " + succesM + "/" + m);
											eclat2User[id]++;
										} // fin if
										else {
											JOptionPane.showMessageDialog(null, "Bonne réponse ! " + succesM + "/" + m);

										}
									} // fin if
									else {
							
										JOptionPane.showMessageDialog(null, "Poto !");
									}

									break;

								case 2:
									// ------- Multiplication

									resultM = alea1M * alea2M;

									repM = JOptionPane.showInputDialog(null,
											"Question " + m + "\nCombien font " + alea1M + " x (" + alea2M + ") ?");

									auxM = checkInt(repM); // checkInt fonction pour vérifier si la saisi d'un nombre
															// est
															// bonne

									j = 1;

									while (((auxM != "oui")) && (j < 3)) {

										// checkInt fonction pour vérifier si la saisi d'un nombre est bonne

										repM = JOptionPane.showInputDialog(null,
												"Mauvaise saisie veuillez réessayer " + "Question " + m
														+ "\nCombien font " + alea1M + " x (" + alea2M + ") ?");
										auxM = checkInt(repM);
										j++;
									}

									if ((j == 3) && (auxM != "oui")) {

										JOptionPane.showMessageDialog(null,
												"Trop d'erreur de saisi, veuillez relancer le défi");
										// connect = "rouge"; si je veux sortir du jeu
										break;
									} else {
										reponseM = Integer.parseInt(repM); // conversion de repF en integer
									}

									if (reponseM == resultM) {
										succesM++;
										if (succesM == 7) {
											JOptionPane.showMessageDialog(null, "Wahou !" + "\nCoup de Génie "
													+ "\nBonus +2pt " + succesM + "/" + m);
											eclat2User[id]++;
										} // fin if
										else {
											JOptionPane.showMessageDialog(null, "Bonne réponse ! " + succesM + "/" + m);

										}
									} // fin if
									else {
										
										JOptionPane.showMessageDialog(null, "Poto !");
									}

									break;

								default:
									JOptionPane.showMessageDialog(null,
											"OUP !!! Une erreur est survenue, veuillez svp relancer le programme !");
									break;
								}
							} // fin pour du jeu moyen
							
							if ((succesM == 5) || (succesM == 6)) {
								scoreUser[id] += 3;
							} else if ((succesM == 7)) {
								scoreUser[id] += 5;
							} else if ((succesM == 4)) {
								scoreUser[id] += 2;
							} else if ((succesM <= 2)) {
								scoreUser[id]--;
							} else {
								scoreUser[id] += 0;
							}
							
							JOptionPane.showMessageDialog(null, "Fin du défis...");
							break;

						case "4": // ------------------------------------------------- Niveau Difficile
							JOptionPane.showMessageDialog(null, "Démarrage Niveau Difficile...");

							// Variable niveau facile
							int alea1D = 0, alea2D = 0, aleaCalculD = 0, resultD = 0, reponseD = 0;
							String auxD = "", repD = "";

							int succesD = 0;

							// Génération d'un nombre aléatoire entre 0 et 5 inclus

							for (int d = 1; d < 8; d++) {

								Random randD = new Random();

								aleaCalculD = randD.nextInt(4); // génère un nombre qui permet de choisir le calcul néccessaire
								
								alea1D = randD.nextInt(31) - 15;
								alea2D = randD.nextInt(31) - 15;

								switch (aleaCalculD) {
								case 0:
									// ------- Somme
									resultD = alea1D + alea2D;

									repD = JOptionPane.showInputDialog(null,
											"Question " + d + "\nCombien font " + alea1D + " + (" + alea2D + ") ?");

									auxD = checkInt(repD); // checkInt fonction pour vérifier si la saisi d'un nombre
															// est
															// bonne

									int j = 1;

									while (((auxD != "oui")) && (j < 3)) {

										// checkInt fonction pour vérifier si la saisi d'un nombre est bonne

										repD = JOptionPane.showInputDialog(null,
												"Mauvaise saisie veuillez réessayer " + "Question " + d
														+ "\nCombien font " + alea1D + " + (" + alea2D + ") ?");
										auxD = checkInt(repD);
										j++;
									}

									if ((j == 3) && (auxD != "oui")) {

										JOptionPane.showMessageDialog(null,
												"Trop d'erreur de saisi, veuillez passez à la question suivante");
										// connect = "rouge"; si je veux sortir du jeu
										break;
									} else {
										reponseD = Integer.parseInt(repD); // conversion de repF en integer
									}

									if (reponseD == resultD) {
										succesD++;
										if (succesD == 7) {
											JOptionPane.showMessageDialog(null, "Wahou !" + "\nCoup de Génie "
													+ "\nBonus +2pt " + succesD + "/" + d);
											eclat2User[id]++;
										} // fin if
										else {
											JOptionPane.showMessageDialog(null, "Bonne réponse ! " + succesD + "/" + d);

										}
									} // fin if
									else {
										
										JOptionPane.showMessageDialog(null, "Poto !");
									}

									break;

								case 1:
									// ------- soustration

									resultD = alea1D - alea2D;

									repD = JOptionPane.showInputDialog(null,
											"Question " + d + "\nCombien font " + alea1D + " - (" + alea2D + ") ?");

									auxD = checkInt(repD); // checkInt fonction pour vérifier si la saisi d'un nombre
															// est
															// bonne

									j = 1;

									while (((auxD != "oui")) && (j < 3)) {

										// checkInt fonction pour vérifier si la saisi d'un nombre est bonne

										repD = JOptionPane.showInputDialog(null,
												"Mauvaise saisie veuillez réessayer " + "Question " + d
														+ "\nCombien font " + alea1D + " - (" + alea2D + ") ?");
										auxD = checkInt(repD);
										j++;
									}

									if ((j == 3) && (auxD != "oui")) {

										JOptionPane.showMessageDialog(null,
												"Trop d'erreur de saisi, veuillez passez à la question suivante");
										// connect = "rouge"; si je veux sortir du jeu
										break;
									} else {
										reponseD = Integer.parseInt(repD); // conversion de repF en integer
									}

									if (reponseD == resultD) {
										succesD++;
										if (succesD == 7) {
											JOptionPane.showMessageDialog(null, "Wahou !" + "\nCoup de Génie "
													+ "\nBonus +2pt " + succesD + "/" + d);
											eclat2User[id]++;
										} // fin if
										else {
											JOptionPane.showMessageDialog(null, "Bonne réponse ! " + succesD + "/" + d);

										}
									} // fin if
									else {
						
										JOptionPane.showMessageDialog(null, "Poto !");
									}

									break;

								case 2:
									// ------- Multiplication

									resultD = alea1D * alea2D;

									repD = JOptionPane.showInputDialog(null,
											"Question " + d + "\nCombien font " + alea1D + " x (" + alea2D + ") ?");

									auxD = checkInt(repD); // checkInt fonction pour vérifier si la saisi d'un nombre
															// est
															// bonne

									j = 1;

									while (((auxD != "oui")) && (j < 3)) {

										// checkInt fonction pour vérifier si la saisi d'un nombre est bonne

										repD = JOptionPane.showInputDialog(null,
												"Mauvaise saisie veuillez réessayer " + "Question " + d
														+ "\nCombien font " + alea1D + " x (" + alea2D + ") ?");
										auxD = checkInt(repD);
										j++;
									}

									if ((j == 3) && (auxD != "oui")) {

										JOptionPane.showMessageDialog(null,
												"Trop d'erreur de saisi, veuillez passez à la question suivante");
										// connect = "rouge"; si je veux sortir du jeu
										break;
									} else {
										reponseD = Integer.parseInt(repD); // conversion de repF en integer
									}

									if (reponseD == resultD) {
										succesD++;
										if (succesD == 7) {
											JOptionPane.showMessageDialog(null, "Wahou !" + "\nCoup de Génie "
													+ "\nBonus +2pt " + succesD + "/" + d);
											eclat2User[id]++;
										} // fin if
										else {
											JOptionPane.showMessageDialog(null, "Bonne réponse ! " + succesD + "/" + d);

										}
									} // fin if
									else {
										
										JOptionPane.showMessageDialog(null, "Poto !");
									}

									break;

								case 3:
									// ------- Quotient

									while ((alea2D == 0) || (alea2D > alea1D)) {
										alea2D = randD.nextInt(31) - 15;
									}
									resultD = alea1D / alea2D;

									repD = JOptionPane.showInputDialog(null,
											"Question " + d + "\nCombien font " + alea1D + " / (" + alea2D + ") ?"
													+ "\n(NB : Donnez que la partie entière de la division)");

									auxD = checkInt(repD); // checkInt fonction pour vérifier si la saisi d'un nombre est bonne
															
									j = 1;

									while (((auxD != "oui")) && (j < 3)) {

										// checkInt fonction pour vérifier si la saisi d'un nombre est bonne

										repD = JOptionPane.showInputDialog(null,
												"Mauvaise saisie veuillez réessayer " + "Question " + d
														+ "\nCombien font " + alea1D + " / (" + alea2D + ") ?\n"
														+ "(NB : Donnez que la partie entière de la division)");
										j++;
									}

									if ((j == 3) && (auxD != "oui")) {

										JOptionPane.showMessageDialog(null,
												"Trop d'erreur de saisi, veuillez passez à la question suivante");
										// connect = "rouge"; si je veux sortir du jeu
										break;
									} else {
										reponseD = Integer.parseInt(repD); // conversion de repF en integer
									}

									if (reponseD == resultD) {
										succesD++;
										if (succesD == 7) {
											JOptionPane.showMessageDialog(null, "Wahou !" + "\nCoup de Génie "
													+ "\nBonus +2pt " + succesD + "/" + d);
											eclat1User[id]++;
										} // fin if
										else {
											JOptionPane.showMessageDialog(null, "Bonne réponse ! " + succesD + "/" + d);

										}
									} // fin if
									else {
							
										JOptionPane.showMessageDialog(null, "Poto !");
									}

									break;
								default:
									JOptionPane.showMessageDialog(null,
											"OUP !!! Une erreur est survenue, veuillez svp relancer le programme !");
									break;
								}

							} // fin pour du jeu difficile
							
							if ((succesD == 5) || (succesD == 6)) {
								scoreUser[id] += 3;
							} else if ((succesD == 7)) {
								scoreUser[id] += 5;
							} else if ((succesD == 4)) {
								scoreUser[id] += 2;
							} else if ((succesD <= 2)) {
								scoreUser[id]--;
							} else {
								scoreUser[id] += 0;
							}

							JOptionPane.showMessageDialog(null, "Fin du défis...");

							break;

						case "5": // ----------------------------------------------------- Niveau Arcade
							JOptionPane.showMessageDialog(null, "Arcade !");

							// Variable niveau facile
							int alea1A = 0, alea2A = 0, aleaCalculA = 0, resultA = 0, reponseA = 0;
							String auxA = "", repA = "";

							int succesA = 0;

							// Génération d'un nombre aléatoire entre 0 et 5 inclus

							for (int a = 1; a < 11; a++) {

								Random randA = new Random();

								aleaCalculA = randA.nextInt(4);

								alea1A = randA.nextInt(31) - 15;
								alea2A = randA.nextInt(31) - 15;

								switch (aleaCalculA) {
								case 0:
									// ------- Somme
									resultA = alea1A + alea2A;

									repA = JOptionPane.showInputDialog(null,
											"Question " + a + "\nCombien font " + alea1A + " + (" + alea2A + ") ?");

									auxA = checkInt(repA); // checkInt fonction pour vérifier si la saisi d'un nombre
															// est
															// bonne

									int j = 1;

									while (((auxA != "oui")) && (j < 3)) {

										// checkInt fonction pour vérifier si la saisi d'un nombre est bonne

										repA = JOptionPane.showInputDialog(null,
												"Mauvaise saisie veuillez réessayer " + "Question " + a
														+ "\nCombien font " + alea1A + " + (" + alea2A + ") ?");
										auxA = checkInt(repA);
										j++;
									}

									if ((j == 3) && (auxA != "oui")) {

										JOptionPane.showMessageDialog(null,
												"Trop d'erreur de saisi, veuillez passez à la question suivante");
										// connect = "rouge"; si je veux sortir du jeu
										break;
									} else {
										reponseA = Integer.parseInt(repA); // conversion de repF en integer
									}

									if (reponseA == resultA) {
										succesA++;
										if (succesA == 10) {
											JOptionPane.showMessageDialog(null, "Wahou !" + "\nCoup de Maître "
													+ "\nBonus +3pt " + succesA + "/" + a);
											eclat3User[id]++;
										} // fin if
										else {
											JOptionPane.showMessageDialog(null, "Bonne réponse ! " + succesA + "/" + a);

										}
									} // fin if
									else {
										
										JOptionPane.showMessageDialog(null, "Poto !");
									}

									break;

								case 1:
									// ------- soustration

									resultA = alea1A - alea2A;

									repA = JOptionPane.showInputDialog(null,
											"Question " + a + "\nCombien font " + alea1A + " - (" + alea2A + ") ?");

									auxA = checkInt(repA); // checkInt fonction pour vérifier si la saisi d'un nombre
															// est
															// bonne

									j = 1;

									while (((auxA != "oui")) && (j < 3)) {

										// checkInt fonction pour vérifier si la saisi d'un nombre est bonne

										repA = JOptionPane.showInputDialog(null,
												"Mauvaise saisie veuillez réessayer " + "Question " + a
														+ "\nCombien font " + alea1A + " - (" + alea2A + ") ?");
										auxA = checkInt(repA);
										j++;
									}

									if ((j == 3) && (auxA != "oui")) {

										JOptionPane.showMessageDialog(null,
												"Trop d'erreur de saisi, veuillez passez à la question suivante");
										// connect = "rouge"; si je veux sortir du jeu
										break;
									} else {
										reponseA = Integer.parseInt(repA); // conversion de repF en integer
									}

									if (reponseA == resultA) {
										succesA++;
										if (succesA == 10) {
											JOptionPane.showMessageDialog(null, "Wahou ! " + "\nCoup de Maître "
													+ "\nBonus +3pt " + succesA + "/" + a);
											eclat3User[id]++;
										} // fin if
										else {
											JOptionPane.showMessageDialog(null, "Bonne réponse ! " + succesA + "/" + a);

										}
									} // fin if
									else {
										
										JOptionPane.showMessageDialog(null, "Poto !");
									}

									break;

								case 2:
									// ------- Multiplication

									resultA = alea1A * alea2A;

									repA = JOptionPane.showInputDialog(null,
											"Question " + a + "\nCombien font " + alea1A + " x (" + alea2A + ") ?");

									auxA = checkInt(repA); // checkInt fonction pour vérifier si la saisi d'un nombre
															// est
															// bonne

									j = 1;

									while (((auxA != "oui")) && (j < 3)) {

										// checkInt fonction pour vérifier si la saisi d'un nombre est bonne

										repA = JOptionPane.showInputDialog(null,
												"Mauvaise saisie veuillez réessayer " + "Question " + a
														+ "\nCombien font " + alea1A + " x (" + alea2A + ") ?");
										auxA = checkInt(repA);
										j++;
									}

									if ((j == 3) && (auxA != "oui")) {

										JOptionPane.showMessageDialog(null,
												"Trop d'erreur de saisi, veuillez passez à la question suivante");
										// connect = "rouge"; si je veux sortir du jeu
										break;
									} else {
										reponseA = Integer.parseInt(repA); // conversion de repF en integer
									}

									if (reponseA == resultA) {
										succesA++;
										if (succesA == 10) {
											JOptionPane.showMessageDialog(null, "Wahou !" + "\nCoup de Maître "
													+ "\nBonus +3pt " + succesA + "/" + a);
											eclat3User[id]++;
										} // fin if
										else {
											JOptionPane.showMessageDialog(null, "Bonne réponse ! " + succesA + "/" + a);

										}
									} // fin if
									else {
										
										JOptionPane.showMessageDialog(null, "Poto !");
									}

									break;

								case 3:
									// ------- Quotient

									while ((alea2A == 0) || (alea2A > alea1A)) {
										alea2A = randA.nextInt(31) - 15;
									}
									resultA = alea1A / alea2A;

									repA = JOptionPane.showInputDialog(null,
											"Question " + a + "\nCombien font " + alea1A + " / (" + alea2A + ") ?"
													+ "\n(NB : Donnez que la partie entière de la division)");

									auxA = checkInt(repA); // checkInt fonction pour vérifier si la saisi d'un nombre
															// est
															// bonne

									j = 1;

									while (((auxA != "oui")) && (j < 3)) {

										// checkInt fonction pour vérifier si la saisi d'un nombre est bonne

										repA = JOptionPane.showInputDialog(null,
												"Mauvaise saisie veuillez réessayer " + "Question " + a
														+ "\nCombien font " + alea1A + " / (" + alea2A + ") ?\n"
														+ "(NB : Donnez que la partie entière de la division)");
										j++;
									}

									if ((j == 3) && (auxA != "oui")) {

										JOptionPane.showMessageDialog(null,
												"Trop d'erreur de saisi, veuillez passez à la question suivante");
										// connect = "rouge"; si je veux sortir du jeu
										break;
									} else {
										reponseA = Integer.parseInt(repA); // conversion de repF en integer
									}

									if (reponseA == resultA) {
										succesA++;
										if (succesA == 10) {
											JOptionPane.showMessageDialog(null, "Wahou !" + "\nCoup de Maître "
													+ "\nBonus +3pt " + succesA + "/" + a);
											eclat3User[id]++;
										} // fin if
										else {
											JOptionPane.showMessageDialog(null, "Bonne réponse ! " + succesA + "/" + a);

										}
									} // fin if
									else {
									
										JOptionPane.showMessageDialog(null, "Poto !");
									}

									break;
								default:
									JOptionPane.showMessageDialog(null,
											"OUP !!! Une erreur est survenue, veuillez svp relancer le programme !");
									break;
								}
							} // fin pour du jeu Arcade

							if ((succesA == 5) || (succesA == 6)) {
								scoreUser[id] += 4;
							} else if ((succesA == 7) || (succesA == 7)) {
								scoreUser[id] += 5;
							} else if ((succesA == 9)) {
								scoreUser[id] += 6;
							} else if ((succesA == 10)) {
								scoreUser[id] += 8;
							} else if ((succesA <= 3)) {
								scoreUser[id]--;
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

					} // fin switch. -----------------------------------------------------------------------------------------------------fin défi

				} // fin while.  ---------------------------------------------------------------------------------------------------------fin connexion 

			} // fin else. --------------------------------------------------------------------------------------------------------------fin déconnecxion

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
			}
			else {
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
