/**
 * Test and create a JFrame and draw class.
 * @author fatihselimyakar
 * @version 1.0.0
 */
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class HW7 {

	private JFrame frame;
	private JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 * @param args command line argument.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HW7 window = new HW7();
					window.frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HW7(){
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(){
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblPickTheInner = new JLabel("Select the inner class.");

		JLabel lblNewLabel = new JLabel("Select the container class.");

		comboBox = new JComboBox<String>();
		comboBox.setToolTipText("Select the inner class");
		comboBox.setMaximumRowCount(3);
		comboBox.setBounds(10, 227, 100, 20);
		comboBox.addItem("Rectangle"); // Choice 1
		comboBox.addItem("Triangle");  // Choice 2
		comboBox.addItem("Circle");    // Choice 3

		final JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setToolTipText("Select the container class");
		comboBox_1.setMaximumRowCount(3);
		comboBox_1.setBounds(10, 227, 100, 20);
		comboBox_1.addItem("Rectangle"); // Choice 1
		comboBox_1.addItem("Triangle");  // Choice 2
		comboBox_1.addItem("Circle");    // Choice 3
		comboBox_1.addItem("Sample PolygonVect");    // Choice 4
		comboBox_1.addItem("Sample PolygonDyn");    // Choice 5
		comboBox_1.addItem("drawAll Test");    // Choice 6
		comboBox_1.addItem("ConvertAll Test");    // Choice 7
		comboBox_1.addItem("Terminal Test");    // Choice 8


		final JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);

		JButton btnDraw = new JButton("Draw");
		btnDraw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				//TESTING CODE IN HERE
				Graphics g = panel.getGraphics();
				// First, design container shape
				try{
					if(comboBox.getSelectedItem().toString()=="Triangle"&&comboBox_1.getSelectedItem().toString()=="Triangle"){
						g.setColor(Color.WHITE); // from now on, use white color
						g.fillRect(0, 0, panel.getWidth(), panel.getHeight());
						panel.paintComponents(g); // the panel will change when THIS function is executed
						Triangle tri1=new Triangle(20,'i');
						Triangle tri2=new Triangle(150,'c');
						ComposedShape comp1=new ComposedShape(tri1,tri2);
						comp1.optimalFit();
						comp1.draw(g);
					}
					else if(comboBox.getSelectedItem().toString()=="Rectangle"&&comboBox_1.getSelectedItem().toString()=="Triangle"){
						g.setColor(Color.WHITE); // from now on, use white color
						g.fillRect(0, 0, panel.getWidth(), panel.getHeight());
						panel.paintComponents(g); // the panel will change when THIS function is executed
						Triangle tri1=new Triangle(200,'c');
						Rectangle rec1=new Rectangle(30,40,'i');
						ComposedShape comp1=new ComposedShape(rec1,tri1);
						comp1.optimalFit();
						comp1.draw(g);
					}
					else if(comboBox.getSelectedItem().toString()=="Circle"&&comboBox_1.getSelectedItem().toString()=="Triangle"){
						g.setColor(Color.WHITE); // from now on, use white color
						g.fillRect(0, 0, panel.getWidth(), panel.getHeight());
						panel.paintComponents(g); // the panel will change when THIS function is executed
						Triangle tri1=new Triangle(200,'c');
						Circle circ1=new Circle(15,'i');
						ComposedShape comp1=new ComposedShape(circ1,tri1);
						comp1.optimalFit();
						comp1.draw(g);
					}
					else if(comboBox.getSelectedItem().toString()=="Circle"&&comboBox_1.getSelectedItem().toString()=="Circle"){
						g.setColor(Color.WHITE); // from now on, use white color
						g.fillRect(0, 0, panel.getWidth(), panel.getHeight());
						panel.paintComponents(g); // the panel will change when THIS function is executed
						Circle circ1=new Circle(100,'c');
						Circle circ2=new Circle(5,'i');
						ComposedShape comp1=new ComposedShape(circ2,circ1);
						comp1.optimalFit();
						comp1.draw(g);
					}
					else if(comboBox.getSelectedItem().toString()=="Triangle"&&comboBox_1.getSelectedItem().toString()=="Circle"){
						g.setColor(Color.WHITE); // from now on, use white color
						g.fillRect(0, 0, panel.getWidth(), panel.getHeight());
						panel.paintComponents(g); // the panel will change when THIS function is executed
						Circle circ1=new Circle(100,'c');
						Triangle tri2=new Triangle(15,'i');
						ComposedShape comp1=new ComposedShape(tri2,circ1);
						comp1.optimalFit();
						comp1.draw(g);
					}
					else if(comboBox.getSelectedItem().toString()=="Rectangle"&&comboBox_1.getSelectedItem().toString()=="Circle"){
						g.setColor(Color.WHITE); // from now on, use white color
						g.fillRect(0, 0, panel.getWidth(), panel.getHeight());
						panel.paintComponents(g); // the panel will change when THIS function is executed
						Rectangle rec1=new Rectangle(15,20,'i');
						Circle circ2=new Circle(100,'c');
						ComposedShape comp1=new ComposedShape(rec1,circ2);
						comp1.optimalFit();
						comp1.draw(g);
					}
					else if(comboBox.getSelectedItem().toString()=="Rectangle"&&comboBox_1.getSelectedItem().toString()=="Rectangle"){
						g.setColor(Color.WHITE); // from now on, use white color
						g.fillRect(0, 0, panel.getWidth(), panel.getHeight());
						panel.paintComponents(g); // the panel will change when THIS function is executed
						Rectangle rec1=new Rectangle(15,20,'i');
						Rectangle rec2=new Rectangle(100,148,'c');
						ComposedShape comp1=new ComposedShape(rec1,rec2);
						comp1.optimalFit();
						comp1.draw(g);
					}
					else if(comboBox.getSelectedItem().toString()=="Circle"&&comboBox_1.getSelectedItem().toString()=="Rectangle"){
						g.setColor(Color.WHITE); // from now on, use white color
						g.fillRect(0, 0, panel.getWidth(), panel.getHeight());
						panel.paintComponents(g); // the panel will change when THIS function is executed
						Circle circ2=new Circle(10,'i');
						Rectangle rec2=new Rectangle(100,148,'c');
						ComposedShape comp1=new ComposedShape(circ2,rec2);
						comp1.optimalFit();
						comp1.draw(g);
					}
					else if(comboBox.getSelectedItem().toString()=="Triangle"&&comboBox_1.getSelectedItem().toString()=="Rectangle"){
						g.setColor(Color.WHITE); // from now on, use white color
						g.fillRect(0, 0, panel.getWidth(), panel.getHeight());
						panel.paintComponents(g); // the panel will change when THIS function is executed
						Triangle tri2=new Triangle(20,'i');
						Rectangle rec2=new Rectangle(100,148,'c');
						ComposedShape comp1=new ComposedShape(tri2,rec2);
						comp1.optimalFit();
						comp1.draw(g);
					}
					else if(comboBox_1.getSelectedItem().toString()=="Sample PolygonVect"){
						g.setColor(Color.WHITE); // from now on, use white color
						g.fillRect(0, 0, panel.getWidth(), panel.getHeight());
						panel.paintComponents(g); // the panel will change when THIS function is executed
						Circle circ=new Circle(50,50,0,'i',150,150,40);
						Rectangle rec2=new Rectangle(100,148,'c');
						Triangle tri=new Triangle(210,210,160,200,200,160);
						PolygonVect vect=new PolygonVect(circ);
						PolygonVect vect2=new PolygonVect(rec2);
						PolygonVect vect3=new PolygonVect(tri);
						vect.draw(g);
						vect2.draw(g);
						vect3.draw(g);
					}
					else if(comboBox_1.getSelectedItem().toString()=="Sample PolygonDyn"){
						g.setColor(Color.WHITE); // from now on, use white color
						g.fillRect(0, 0, panel.getWidth(), panel.getHeight());
						panel.paintComponents(g); // the panel will change when THIS function is executed
						Circle circ=new Circle(50,50,0,'c',200,100,50);
						Rectangle rec2=new Rectangle(100,148,'i');
						Triangle tri=new Triangle(210,210,160,200,200,160);
						PolygonDyn dyn=new PolygonDyn(circ);
						PolygonDyn dyn2=new PolygonDyn(rec2);
						PolygonDyn dyn3=new PolygonDyn(tri);
						dyn.draw(g);
						dyn2.draw(g);
						dyn3.draw(g);
					}
					else if(comboBox_1.getSelectedItem().toString()=="drawAll Test"){
						g.setColor(Color.WHITE); // from now on, use white color
						g.fillRect(0, 0, panel.getWidth(), panel.getHeight());
						panel.paintComponents(g); // the panel will change when THIS function is executed
						Shape[]array={new Rectangle(100,148,'i')};
						Globals drawAllFunc=new Globals();
						drawAllFunc.drawAll(array,g);
					}
					else if(comboBox_1.getSelectedItem().toString()=="ConvertAll Test"){
						g.setColor(Color.WHITE); // from now on, use white color
						g.fillRect(0, 0, panel.getWidth(), panel.getHeight());
						panel.paintComponents(g); // the panel will change when THIS function is executed
						Shape[]array={new Triangle(210,210,160,200,200,160),new Rectangle(100,148,'i'),new Circle(50,50,0,'c',200,100,50)};
						Globals drawAllFunc=new Globals();
						Shape[]polyArr=new PolygonVect[3];
						polyArr=drawAllFunc.convertAll(array);
						for(int i=0;i<polyArr.length;++i)
							polyArr[i].draw(g);
					}
					else if(comboBox_1.getSelectedItem().toString()=="Terminal Test"){
						g.setColor(Color.WHITE); // from now on, use white color
						g.fillRect(0, 0, panel.getWidth(), panel.getHeight());
						panel.paintComponents(g); // the panel will change when THIS function is executed
						//I use the compareTo in sort function because of this I dont test here.
						Shape[]array={new Circle(50,50,0,'c',200,100,50),new Triangle(20,'i'),new Rectangle(100,100,'i'),new Rectangle(13,20,'i')};
						System.out.printf("\n**sortShapes Test**\nUnsorted Values:");
						for(int i=0;i<array.length;++i)
							System.out.printf("%.0f ",array[i].area());
						System.out.printf("\nSorted Values:");
						Globals sortShape=new Globals();
						sortShape.sortShapes(array);
						for(int i=0;i<array.length;++i)
							System.out.printf("%.0f ",array[i].area());

						Circle circ=new Circle(50,50,0,'c',200,100,50);
						Triangle tri=new Triangle(20,'i');
						Rectangle rec=new Rectangle(100,100,'i');
						ComposedShape comp=new ComposedShape(tri,circ);
						PolygonDyn polydyn=new PolygonDyn(circ);
						PolygonVect polyvect=new PolygonVect(rec);
						comp.optimalFit();
						System.out.printf("\n\n**Before increment and decrement**\n");
						System.out.printf("Circle:%.0f %.0f",circ.getCenterCoordX(),circ.getCenterCoordY());
						System.out.printf("\nPolygonDyn:%.0f %.0f",polydyn.getPosX(),polydyn.getPosY());
						System.out.printf("\nPolygonVec:%.0f %.0f",polyvect.getPosX(),polyvect.getPosY());
						System.out.printf("\nRectangle:%.0f %.0f",rec.getPosX(),rec.getPosY());
						System.out.printf("\nTriangle:%.0f %.0f %.0f %.0f %.0f %.0f",tri.getTriX(),tri.getTriY(),tri.getTri2X(),tri.getTri2Y(),tri.getTri3X(),tri.getTri3Y());
						System.out.printf("\n**After increment**\n");
						circ.increment(); tri.increment(); rec.increment(); polydyn.increment(); polyvect.increment();
						System.out.printf("Circle:%.0f %.0f",circ.getCenterCoordX(),circ.getCenterCoordY());
						System.out.printf("\nPolygonDyn:%.0f %.0f",polydyn.getPosX(),polydyn.getPosY());
						System.out.printf("\nPolygonVec:%.0f %.0f",polyvect.getPosX(),polyvect.getPosY());
						System.out.printf("\nRectangle:%.0f %.0f",rec.getPosX(),rec.getPosY());
						System.out.printf("\nTriangle:%.0f %.0f %.0f %.0f %.0f %.0f",tri.getTriX(),tri.getTriY(),tri.getTri2X(),tri.getTri2Y(),tri.getTri3X(),tri.getTri3Y());
						System.out.printf("\n**After ComposedShape increment(inner is triangle,container is circle)**\n");
						comp.increment();
						System.out.printf("Circle:%.0f %.0f",circ.getCenterCoordX(),circ.getCenterCoordY());
						System.out.printf("\nPolygonDyn:%.0f %.0f",polydyn.getPosX(),polydyn.getPosY());
						System.out.printf("\nPolygonVec:%.0f %.0f",polyvect.getPosX(),polyvect.getPosY());
						System.out.printf("\nRectangle:%.0f %.0f",rec.getPosX(),rec.getPosY());
						System.out.printf("\nTriangle:%.0f %.0f %.0f %.0f %.0f %.0f",tri.getTriX(),tri.getTriY(),tri.getTri2X(),tri.getTri2Y(),tri.getTri3X(),tri.getTri3Y());
						System.out.printf("\n**After ComposedShape decrement(inner is triangle,container is circle)**\n");
						comp.decrement();
						System.out.printf("Circle:%.0f %.0f",circ.getCenterCoordX(),circ.getCenterCoordY());
						System.out.printf("\nPolygonDyn:%.0f %.0f",polydyn.getPosX(),polydyn.getPosY());
						System.out.printf("\nPolygonVec:%.0f %.0f",polyvect.getPosX(),polyvect.getPosY());
						System.out.printf("\nRectangle:%.0f %.0f",rec.getPosX(),rec.getPosY());
						System.out.printf("\nTriangle:%.0f %.0f %.0f %.0f %.0f %.0f",tri.getTriX(),tri.getTriY(),tri.getTri2X(),tri.getTri2Y(),tri.getTri3X(),tri.getTri3Y());
						System.out.printf("\n**After decrement**\n");
						circ.decrement(); tri.decrement(); rec.decrement(); polydyn.decrement(); polyvect.decrement();
						System.out.printf("Circle:%.0f %.0f",circ.getCenterCoordX(),circ.getCenterCoordY());
						System.out.printf("\nPolygonDyn:%.0f %.0f",polydyn.getPosX(),polydyn.getPosY());
						System.out.printf("\nPolygonVec:%.0f %.0f",polyvect.getPosX(),polyvect.getPosY());
						System.out.printf("\nRectangle:%.0f %.0f",rec.getPosX(),rec.getPosY());
						System.out.printf("\nTriangle:%.0f %.0f %.0f %.0f %.0f %.0f",tri.getTriX(),tri.getTriY(),tri.getTri2X(),tri.getTri2Y(),tri.getTri3X(),tri.getTri3Y());
						System.out.printf("\n\n**Area-perimeter Test**\n");
						System.out.printf("Circle area:%.0f,Rectangle area:%.0f,Triangle area:%.0f,ComposedShape total area:%.0f,PolygonVect area:%.0f,PolygonDyn area:%.0f\n",circ.area(),rec.area(),tri.area(),comp.area(),polyvect.area(),polydyn.area());
						System.out.printf("Circle perimeter:%.0f,Rectangle perimeter:%.0f,Triangle perimeter:%.0f,ComposedShape total perimeter:%.0f,PolygonVect perimeter:%.0f,PolygonDyn perimeter:%.0f\n",circ.perimeter(),rec.perimeter(),tri.perimeter(),comp.perimeter(),polyvect.perimeter(),polydyn.perimeter());
						System.out.printf("\n**CompareTo Test**\n");
						System.out.printf("Compare with ComposedShape and Circle:%d\n",comp.compareTo(circ));
						System.out.printf("Compare with Circle and Rectangle:%d\n",circ.compareTo(rec));
						System.out.printf("Compare with Rectangle and Triangle:%d\n",rec.compareTo(tri));
						System.out.printf("Compare with Triangle and Circle:%d\n",tri.compareTo(circ));
						System.out.printf("Compare with PolygonDyn and PolygonVect:%d\n",polydyn.compareTo(polyvect));
						System.out.printf("Compare with PolygonVect and PolygonDyn:%d\n",polyvect.compareTo(polydyn));

					}




				}
				catch(MyException error){
					System.out.printf("%s",error.what());
				}

				// paintComponents Method Using
				// Now paint component with the graphics
				panel.paintComponents(g);



			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(lblPickTheInner)))
					.addGap(18)
					.addComponent(btnDraw, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(comboBox_1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(19))))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(21, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 412, GroupLayout.PREFERRED_SIZE)
					.addGap(17))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblPickTheInner))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDraw)))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	public JComboBox<String> getComboBox() {
		return comboBox;
	}
}
