/*
	Names: Asheber Arlain, David Nguyen 
	Prog for IT III 
	Breakthrough Project 
	3/22/12 
*/
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;

//This is our Pokemon Breakthrough game 
public class Breakthrough extends JFrame implements ActionListener 
{
	private JFrame board;
 
	private Piece pieces[][]; 
	
	//Fire - pieces in the western quadrant 
	ImageIcon charmeleon = new ImageIcon("images/charmeleon.jpg", "fire");
	ImageIcon charizard = new ImageIcon("images/charizard.jpg", "fire");
	ImageIcon charmander = new ImageIcon("images/charmander.jpg", "fire");
	ImageIcon growlithe = new ImageIcon("images/growlithe.jpg", "fire");
	ImageIcon arcanine = new ImageIcon("images/arcanine.jpg", "fire");
	ImageIcon entei = new ImageIcon("images/entei.jpg", "fire");
	ImageIcon cyndaquil = new ImageIcon("images/cyndaquil.jpg","fire");
	ImageIcon hooh = new ImageIcon("images/hooh.jpg", "fire");
	ImageIcon magmar = new ImageIcon("images/magmar.jpg", "fire");
	ImageIcon ninetails = new ImageIcon("images/ninetails.jpg", "fire");
	ImageIcon moltres = new ImageIcon("images/moltres.jpg", "fire");
	ImageIcon quilava = new ImageIcon("images/quilava.jpg", "fire");
	ImageIcon typhlosion = new ImageIcon("images/typhlosion.jpg", "fire");
	ImageIcon torchic = new ImageIcon("images/torchic.jpg", "fire");
	ImageIcon flareon = new ImageIcon("images/flareon.jpg", "fire");
	ImageIcon vulpix = new ImageIcon("images/vulpix.jpg", "fire");
	
	//Ice+Water - pieces in the eastern quadrant 
	ImageIcon articuno = new ImageIcon("images/articuno.jpg", "ice");
	ImageIcon blastoise = new ImageIcon("images/blastoise.jpg", "ice");
	ImageIcon cloyster = new ImageIcon("images/cloyster.jpg", "ice");
	ImageIcon dewgong = new ImageIcon("images/dewgong.jpg", "ice");
	ImageIcon glaceon = new ImageIcon("images/glaceon.jpg", "ice");
	ImageIcon golduck= new ImageIcon("images/golduck.jpg", "ice");
	ImageIcon lapras = new ImageIcon("images/lapras.jpg", "ice");
	ImageIcon psyduck = new ImageIcon("images/psyduck.jpg", "ice");
	ImageIcon seel = new ImageIcon("images/seel.jpg", "ice");
	ImageIcon slowking = new ImageIcon("images/slowking.jpg", "ice");
	ImageIcon slowpoke = new ImageIcon("images/slowpoke.jpg", "ice");
	ImageIcon squirtle = new ImageIcon("images/squirtle.jpg", "ice");
	ImageIcon starmie = new ImageIcon("images/starmie.jpg", "ice");
	ImageIcon staryu = new ImageIcon("images/staryu.jpg", "ice");
	ImageIcon wartortle = new ImageIcon("images/wartortle.jpg", "ice");
	ImageIcon magikarp = new ImageIcon("images/magikarp.jpg", "ice");
	
	//constructor 
	public Breakthrough()
	{
		board = new JFrame("Breakthrough");
		board.setSize(700,700);  
		board.setLayout(new GridLayout(8,8)); 
		pieces = new Piece[8][8]; ; 
		
		//Creates the grid
		for(int x = 0; x < 8; x++)
		{
			for(int y = 0; y < 8; y++)
			{ 
				pieces[x][y] = new Piece(x, y);  
				board.add(pieces[x][y]);
				pieces[x][y].addActionListener(this); 
			}
		}
		
		//places custon icons to each specific jbutton  
		pieces[0][0].setIcon(charmeleon);
	   pieces[1][0].setIcon(charizard);
	   pieces[2][0].setIcon(charmander);
	   pieces[3][0].setIcon(arcanine);
	   pieces[4][0].setIcon(cyndaquil);
		pieces[5][0].setIcon(entei);
		pieces[6][0].setIcon(hooh);
		pieces[7][0].setIcon(flareon);
		pieces[0][1].setIcon(growlithe);
	   pieces[1][1].setIcon(magmar);
	   pieces[2][1].setIcon(vulpix);
		pieces[3][1].setIcon(moltres);
		pieces[4][1].setIcon(ninetails);
		pieces[5][1].setIcon(quilava);
		pieces[6][1].setIcon(torchic);
		pieces[7][1].setIcon(typhlosion);
	   
		pieces[0][6].setIcon(articuno);
	   pieces[1][6].setIcon(blastoise);
	   pieces[2][6].setIcon(cloyster);
	   pieces[3][6].setIcon(dewgong);
	   pieces[4][6].setIcon(glaceon);
	   pieces[5][6].setIcon(golduck);
		pieces[6][6].setIcon(lapras);
		pieces[7][6].setIcon(psyduck);
		pieces[0][7].setIcon(seel);
	   pieces[1][7].setIcon(slowking);
	   pieces[2][7].setIcon(slowpoke);
		pieces[3][7].setIcon(squirtle);
		pieces[4][7].setIcon(starmie);
		pieces[5][7].setIcon(staryu);
		pieces[6][7].setIcon(wartortle);
		pieces[7][7].setIcon(magikarp);
		
		
		board.setVisible(true); 
		board.setLocationRelativeTo(null);
		board.setResizable(false); 
		board.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//fire 
	public void actionPerformed(ActionEvent ae)
	{//top of ae
		Piece p = (Piece) ae.getSource();
		final int px = p.getXPos(); 
		final int py = p.getYPos();
		p.setSelected(true); 
		
		//define player
		if(p.isSelected() == true)
		{//top of if 
			for(int x = 0; x < 8; x++)
			{//top of for loop 
				for(int y = 0; y < 8; y++)
				{//second for 
					if(pieces[px][py].getIcon() != null) 
					{
						ImageIcon im = (ImageIcon) pieces[px][py].getIcon();
						//fire pokemon team movement functionality 
						if(im.getDescription().equals("fire"))
						{//Top If
							try
							{
								pieces[x][y].setEnabled(false); 
								pieces[px][py+1].setEnabled(true);
								pieces[px+1][py+1].setEnabled(true);
								pieces[px-1][py+1].setEnabled(true);					
							}
							catch(ArrayIndexOutOfBoundsException ai)
							{
								try
								{
									pieces[x][y].setEnabled(false); 
									pieces[px][py+1].setEnabled(true);
									pieces[px+1][py+1].setEnabled(true);
									
								}
								catch(ArrayIndexOutOfBoundsException ai2) 
								{
									pieces[x][y].setEnabled(false); 
									pieces[px][py+1].setEnabled(true);
									pieces[px-1][py+1].setEnabled(true);
								}
							}
							
							pieces[x][y].removeActionListener(this); 
							
							if(pieces[x][y].isEnabled() == true)
							{
								pieces[x][y].addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent ae)
									{
										Piece p2 = (Piece) ae.getSource();
										int pxNew = p2.getXPos(); 
										int pyNew = p2.getYPos();
										ImageIcon prevImg = (ImageIcon) pieces[px][py].getIcon();
										ImageIcon currImg = (ImageIcon) pieces[pxNew][pyNew].getIcon();
										ImageIcon inFront = (ImageIcon) pieces[px][py+1].getIcon();

										if(prevImg != null)
										{
											if(currImg!=null && currImg.getDescription().equals("ice") && currImg.equals(inFront))
											{
												pieces[pxNew][pyNew].setEnabled(false);
												currImg = prevImg; 
											}
											 if(currImg!=null && currImg.getDescription().equals("fire"))
											{
												pieces[pxNew][pyNew].setEnabled(false); 
											}
											else if(currImg == null || currImg.getDescription().equals("ice"))
											{ 
												pieces[pxNew][pyNew].setIcon(prevImg);
												pieces[px][py].setIcon(null); 
												
												if(pieces[pxNew][pyNew] == pieces[pxNew][7])
												{
													JOptionPane.showMessageDialog(null, "Your fire pokemans are the winners. You are the pokemon master!!");
													System.exit(0);
												}
											}
										}	
					
										pieces[pxNew][pyNew].setEnabled(true); 
										
										for(int x = 0; x < 8; x++)
										{
											for(int y = 0; y < 8; y++)
											{ 
												pieces[x][y].setEnabled(true);
												pieces[x][y].removeActionListener(this); 
												pieces[x][y].addActionListener(Breakthrough.this); 
											}
										} 
									}
								});
							}
						}//end fire pokemon team functionality 
						
						//ice pokemon team movement functionality 
						if(im.getDescription().equals("ice"))
						{//Top If
							//ImageIcon im = (ImageIcon) pieces[x][y].getIcon();
							try
							{
								pieces[x][y].setEnabled(false); 
								pieces[px][py-1].setEnabled(true);
								pieces[px-1][py-1].setEnabled(true);
								pieces[px+1][py-1].setEnabled(true);					
							}
							catch(ArrayIndexOutOfBoundsException ai)
							{
								try
								{
									pieces[x][y].setEnabled(false); 
									pieces[px][py-1].setEnabled(true);
									pieces[px-1][py-1].setEnabled(true);
									
								}
								catch(ArrayIndexOutOfBoundsException ai2) 
								{
									pieces[x][y].setEnabled(false); 
									pieces[px][py-1].setEnabled(true);
									pieces[px+1][py-1].setEnabled(true);
								}
							}
							
							pieces[x][y].removeActionListener(this); 
							
							if(pieces[x][y].isEnabled() == true)
							{
								pieces[x][y].addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent ae)
									{
										Piece p = (Piece) ae.getSource();
										int pxNew = p.getXPos(); 
										int pyNew = p.getYPos();
										ImageIcon prevImg = (ImageIcon) pieces[px][py].getIcon();
										ImageIcon currImg = (ImageIcon) pieces[pxNew][pyNew].getIcon();
										ImageIcon inFront = (ImageIcon) pieces[px][py-1].getIcon();

										if(prevImg != null)
										{
										   if(currImg!=null && currImg.getDescription().equals("fire") && currImg.equals(inFront))
											{
												pieces[pxNew][pyNew].setEnabled(false);
												currImg = prevImg; 
											}
										   if(currImg!=null && currImg.getDescription().equals("ice"))
											{
												pieces[pxNew][pyNew].setEnabled(false); 
											}
											
											else if(currImg == null || currImg.getDescription().equals("fire"))
											{ 
												pieces[pxNew][pyNew].setIcon(prevImg);
												pieces[px][py].setIcon(null);
												
												if(pieces[pxNew][pyNew] == pieces[pxNew][0])
												{
													JOptionPane.showMessageDialog(null, "Your ice pokemans are the winners. You are the pokemon master!!");
													System.exit(0);
												} 
											}
										}	
										
										pieces[pxNew][pyNew].setEnabled(true); 
										pieces[pxNew][pyNew-1].setEnabled(true); 

										for(int x = 0; x < 8; x++)
										{
											for(int y = 0; y < 8; y++)
											{ 
												pieces[x][y].setEnabled(true);
												pieces[x][y].removeActionListener(this); 
												pieces[x][y].addActionListener(Breakthrough.this); 
											}
										} 
									}
								});
							}
						}//end ice pokemon team functionality 
					}
				}//Second for	
			}//1st for
		}//1st if
	}//End Action Performed
		 		
	//inner class that extends jbutton 	
	class Piece extends JButton
	{
		private int x,y,side;  
		private String type; 
		
		//constructor 
		public Piece(int _x, int _y)
		{
			x = _x; 
			y = _y;
		}
		
		//accessors 
		public int getXPos()
		{
			return x; 
		}
		public int getYPos()
		{
			return y; 
		}
		
		//mutators 
		public void setXPos(int _x)
		{
			x = _x;  
		}
		public void setYPos(int _y)
		{
			y = _y;  
		}
	}
	
	//main 
	public static void main(String[] args)
	{
		Breakthrough bt = new Breakthrough(); 
	}
}

