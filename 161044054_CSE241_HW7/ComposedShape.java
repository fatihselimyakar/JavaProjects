/**
 * Calculate and generate the other classes datas.
 * @author fatihselimyakar
 * @version 1.0.0
 */
import java.awt.Graphics;

public class ComposedShape implements Shape{
    public static final double SQR3DIV2 = 0.866;
    public static final double SQR3 = 1.7320;


    private Shape inner;
    private Shape container;
    private Shape[]shapes;
    private int size;


    /**
     * ComposedShape() no parameter constructor that assigns null ptr and defaulted array size.
     */
    public ComposedShape(){
        inner=null;
        container=null;
        size=0;
        shapes=new Shape[1000];
    }
    /**
     * ComposedShape() constructor that assign parameter to data members and defaulted array size.
     * @param in inner shape's object.
     * @param con container shape's object.
     */
    public ComposedShape(Shape in,Shape con){
        inner=in;
        container=con;
        size=0;
        shapes=new Shape[1000];
    }

    /**
     * Getter that is returning size.
     * @return return the size.
     */
    public int getSize(){ return size; }
    /**
     * Getter that is returning shape of inner.
     * @return return the inner shape.
     */
    public Shape getInner(){ return inner; }
    /**
     * Getter that is returning shape of container.
     * @return return the container shape.
     */
    public Shape getContainer(){ return container; }
    /**
     * Getter that is returning shape array.
     * @return return the array of shapes
     */
    public Shape[] getShapePtrVec(){ return shapes; }


    /**
     * optimalFit() provides a calculates for the inner and fit in the container.
     * @exception MyException If the container and inner type is not incompetible then throws error.
     */
    public void optimalFit()throws MyException{
        if(container instanceof Triangle){
            Triangle Co=(Triangle)container;
            shapes[size]=Co;
            if(inner instanceof Triangle){
                Triangle In=(Triangle)inner;
                int nOfTri=Co.getLateral()/In.getLateral();
            	int plus;
            	//the starting coordinates
            	double x=Co.getLateral()/2.0,y=0;
            	int k,l,m=1;
            	for(k=nOfTri;k>0;k--){
            		plus=0;
            		for(l=0;l<m;l++,plus=plus+In.getLateral()){
            			//prints normal triangles
            			//generate the one small shape and saves the vector
                        Triangle normal=new Triangle();
                        Triangle temp= new Triangle(In.getLateral(),'i',x+plus,y,x+In.getLateral()/2.0+plus,y+(In.getLateral()*SQR3DIV2),x-(In.getLateral()/2.0)+plus,y+(In.getLateral()*SQR3DIV2),0,0,0);
                        normal=temp;
                        ++size;
                        shapes[size]=normal;
            			//for the reverse type triangle's and the if is need to last line
            			if(k!=1){
            				//set the one small shape and saves the vector
                            Triangle normal2=new Triangle(In.getLateral(),'i',x+plus,y+(2*In.getLateral()*SQR3DIV2),x+In.getLateral()/2.0+plus,y+(In.getLateral()*SQR3DIV2),x-(In.getLateral()/2.0)+plus,y+(In.getLateral()*SQR3DIV2),0,0,0);
                            ++size;
                            shapes[size]=normal2;
            			}

            		}
            		m=m+1;
            		x=x-In.getLateral()/2.0;//updating x coordinates
            		y=y+In.getLateral()*SQR3DIV2;//updating y coordinates
            	}
            }
            else if(inner instanceof Rectangle){
                Rectangle In=(Rectangle)inner;
            	//calculates for the two issues.width to lateral and height to lateral
            	double NormalSide=Co.getLateral()-2*(In.getHeight()/SQR3);
            	double ReverseSide=Co.getLateral()-2*(In.getWidth()/SQR3);
            	//It calculates the number of triangle along the h
            	int hNo=(int)((SQR3DIV2*Co.getLateral())-(In.getWidth()*SQR3DIV2))/In.getHeight();
            	int hRe=(int)((SQR3DIV2*Co.getLateral())-(In.getHeight()*SQR3DIV2))/In.getWidth();
            	//line by line calculating for normal align
            	int i,j,normal=0,reverse=0;
            	for(i=hNo;i>0;i--){
            		normal=normal+(int)(NormalSide/In.getWidth());
            		if(NormalSide>0)
            			NormalSide=NormalSide-2*(In.getHeight()/SQR3);
            	}
            	//line by line calculating for reverse align
            	for(j=hRe;j>0;j--){
            		reverse=reverse+(int)(ReverseSide/In.getHeight());
            		if(ReverseSide>0)
            			ReverseSide=ReverseSide-2*(In.getWidth()/SQR3);
            	}
            	//printing the .svg files

            	if(normal>reverse){//for width to lateral and height to h(normal align)
            		//for the updating x coordinates
            		int plus=In.getWidth();
            		//the starting coordinates
            		double x=In.getHeight()/SQR3,y=(Co.getLateral()*SQR3DIV2)-In.getHeight();
            		int k,l;
            		//the clear-cut h for dividing
            		double m=Co.getLateral()-2*(In.getHeight()/SQR3);
            		for(k=hNo;k>0;k--){
            			plus=0;
            			for(l=(int)(m/In.getWidth());l>0;l--,plus=plus+In.getWidth()){
            				//generate the one small shape and saves the vector
                            Rectangle drawRec= new Rectangle(In.getHeight(),In.getWidth(),x+plus,y,0,'i');
                            ++size;
            				shapes[size]=drawRec;

            			}
            			//updatings for coordinates and loop's data
            			m=m-2*(In.getHeight()/SQR3);
            			x=x+In.getHeight()/SQR3;
            			y=y-In.getHeight();
            		}

            	}
            	else{//for height to lateral and width to h(reverse align)
            		int plus=In.getHeight();
            		double x=In.getWidth()/SQR3,y=(Co.getLateral()*SQR3DIV2)-In.getWidth();
            		int k,l;
            		double m=(Co.getLateral()-2*(In.getWidth()/SQR3));
            		for(k=hRe;k>0;k--){
            			plus=0;
            			for(l=(int)(m/In.getHeight());l>0;l--,plus=plus+In.getHeight()){
            				//generate the one small shape and saves the vector
                            Rectangle drawRec=new Rectangle(In.getWidth(),In.getHeight(),x+plus,y,0,'i');
                            ++size;
            				shapes[size]=drawRec;
            			}
            			m=m-2*(In.getWidth()/SQR3);
            			x=x+In.getWidth()/SQR3;
            			y=y-In.getWidth();
            		}

            	}

            }
            else if(inner instanceof Circle){
                Circle In=(Circle)inner;
            	//side is the max number of circle fill the line
            	double side=Co.getLateral()-2*(In.getRadius()/SQR3)-(2*In.getRadius()/SQR3)+In.getRadius();
            	//net height of rectangle
            	int h=(int)(((SQR3DIV2*Co.getLateral())-In.getRadius())/(2*In.getRadius()));
            	//I calculate the total circle number
            	int i,sum=0;
            	for(i=h;i>0;i--){
            		sum=sum+(int)(side/(2*In.getRadius()));
            		if(side>0)
            			side=side-(4*In.getRadius()/SQR3);
            	}
            	//the first updating value
            	double plus=2*In.getRadius();
            	//coordinates
            	double x=3*In.getRadius()/SQR3,y=(Co.getLateral()*SQR3DIV2)-In.getRadius();
            	int k,l;
            	//m is the max number of circle fill the line
            	double m=Co.getLateral()-2*(In.getRadius()/SQR3)-(2*In.getRadius()/SQR3)+In.getRadius();
            	for(k=h;k>0;k--){
            		plus=0;
            		for(l=(int)(m/(2*In.getRadius()));l>0;l--,plus=plus+2*In.getRadius()){
            			//generate the one small shape and saves the vector
            			Circle drawCirc=new Circle(0,0,0,'i',x+plus,y,In.getRadius());
                        ++size;
            			shapes[size]=drawCirc;
            		}
            		//updates
            		m=m-4*(In.getRadius()/SQR3);
            		x=x+2*(In.getRadius()/SQR3);
            		y=y-2*In.getRadius();
            	}
            }
            else
                throw new MyException("UNVALID SHAPE TYPE IN OPTIMALFIT");
        }
        else if(container instanceof Rectangle){
            Rectangle Co=(Rectangle)container;
            shapes[size]=Co;
            if(inner instanceof Triangle){
                Triangle In=(Triangle)inner;
            	int normal,reverse,normalNofTriWidth,reverseNofTriHeight;

            	//It calculates normal and reverse align calculates(on width and height)
            	normalNofTriWidth=(int)(Co.getHeight()/(SQR3DIV2*In.getLateral()));
            	reverseNofTriHeight=(int)(Co.getWidth()/(SQR3DIV2*In.getLateral()));

            	//This parts includes exception issue's triangles
            	if((Co.getWidth()%In.getLateral())>=(In.getLateral()/2))
            		normal=(2*(Co.getWidth()/In.getLateral()));
            	else
            		normal=(2*(Co.getWidth()/In.getLateral()))-1;
            	normal=normal*normalNofTriWidth;

            	//This parts includes exception issue's triangles too for reverse
            	if((Co.getHeight()%In.getLateral())>=(In.getLateral()/2))
            		reverse=(2*(Co.getHeight()/In.getLateral()));
            	else
            		reverse=(2*(Co.getHeight()/In.getLateral()))-1;
            	reverse=reverse*reverseNofTriHeight;

            	//Printing normal align triangles
            	if(normal>reverse){
            		double i,j;
            		for(j=0;j+(SQR3*(In.getLateral()/2.0))<=Co.getHeight();j=j+(SQR3*(In.getLateral()/2.0))){
            			for(i=0;i+In.getLateral()<=Co.getWidth();i=i+In.getLateral()){
            				//generate the one small shape and saves the vector
                            Triangle normal1=new Triangle(In.getLateral(),'i',i,j,In.getLateral()+i,j,(In.getLateral()/2.0)+i,SQR3*(In.getLateral()/2.0)+j,0,0,0);
                            ++size;
                            shapes[size]=normal1;
            			}
            		}
            		//prints reverse type triangle
            		double k,l;
            		for(l=(SQR3*(In.getLateral()/2.0));l<=Co.getHeight();l=l+(SQR3*(In.getLateral()/2.0))){
            			for(k=In.getLateral()/2.0;k+In.getLateral()<=Co.getWidth();k=k+In.getLateral()){
            				//generate the one small shape and saves the vector
                            Triangle normal2=new Triangle(In.getLateral(),'i',k,l,In.getLateral()/2.0+k,l-(SQR3*(In.getLateral()/2.0)),In.getLateral()+k,l,0,0,0);
                            ++size;
            				shapes[size]=normal2;
            			}
            		}

            	}
            	//Printing reverse align triangles
            	else{
            		//prints reverse type triangle
            		double i,j;
            		for(i=0;i+(SQR3*(In.getLateral()/2.0))<=Co.getWidth();i=i+(SQR3*(In.getLateral()/2.0))){
            			for(j=0;j+In.getLateral()<=Co.getHeight();j=j+In.getLateral()){
            				//generate the one small shape and saves the vector
                            Triangle normal3=new Triangle(In.getLateral(),'i',i,j,i,j+In.getLateral(),SQR3*(In.getLateral()/2.0)+i,(In.getLateral()/2.0)+j,0,0,0);
                            ++size;
            				shapes[size]=normal3;
            			}
            		}
            		//prints normal type triangle
            		double k,l;
            		for(l=(In.getLateral()/2.0);l+In.getLateral()<=Co.getHeight();l=l+In.getLateral()){
            			for(k=(SQR3*(In.getLateral()/2.0));k<=Co.getWidth();k=k+(SQR3*(In.getLateral()/2.0))){
            				//generate the one small shape and saves the vector
                            Triangle normal4=new Triangle(In.getLateral(),'i',k,l,k-(SQR3*(In.getLateral()/2.0)),In.getLateral()/2.0+l,k,In.getLateral()+l,0,0,0);
                            ++size;
            				shapes[size]=normal4;
            			}
            		}
            	}
            }
            else if(inner instanceof Rectangle){
                Rectangle In=(Rectangle)inner;

            	int normal,reverse,addForEmpty1,addForEmpty2,temp;
            	int smallwidth=In.getWidth();
            	int smallheight=In.getHeight();
            	if(smallwidth<smallheight){//My program is runs the only when small.width>small.height.This ıf provides that.
            		temp=smallwidth;
            		smallwidth=smallheight;
            		smallheight=temp;
            	}
            	//The program runs two way the first is normal issue.align the width to width and height to height
            	normal=(Co.getWidth()/smallwidth)*(Co.getHeight()/smallheight);
            	//second is width to height and height to width
            	reverse=(Co.getHeight()/smallwidth)*(Co.getWidth()/smallheight);

            	//if there are spaces in big shape then adds the rotated rectangles for normal and reverse align
            	addForEmpty1=(((Co.getWidth()-((Co.getWidth()/smallwidth)*smallwidth))/smallheight)*(Co.getHeight()/smallwidth));
            	addForEmpty2=(((Co.getHeight()-((Co.getHeight()/smallwidth)*smallwidth))/smallheight)*(Co.getWidth()/smallwidth));

            	//I calculated the total rectangle number
            	normal=normal+addForEmpty1;
            	reverse=reverse+addForEmpty2;

            	if(normal>reverse){//This part is printing .svg file and print in datas in terminal
            		int i,j,k,l;
            		for(i=0;i+smallwidth<=Co.getWidth();i=i+smallheight){
            			for(j=0;j+smallheight<=Co.getHeight();j=j+smallheight){
            				//generate the one small shape and saves the vector
            				Rectangle normal1=new Rectangle(smallheight,smallwidth,i,j,0,'i');
                            ++size;
            				shapes[size]=normal1;
            			}
            		}
            		//this part prints added and rotated rectangles
            		for(k=i;k+smallheight<=Co.getWidth();k=k+smallheight){
            			for(l=0;l+smallwidth<=Co.getHeight();l=l+smallwidth){
            				//generate the one small shape and saves the vector
            				Rectangle normal2=new Rectangle(smallwidth,smallheight,k,l,0,'i');
                            ++size;
            				shapes[size]=normal2;
            			}
            		}


            	}
            	else{
            		int i=0,j=0,k=0,l=0;
            		for(i=0;i+smallheight<=Co.getWidth();i=i+smallheight){
            			for(j=0;j+smallwidth<=Co.getHeight();j=j+smallwidth){
            				//generate the one small shape and saves the vector
            				Rectangle reverse3=new Rectangle(smallwidth,smallheight,i,j,0,'i');
                            ++size;
            				shapes[size]=reverse3;

            			}
            		}
            		//this part prints added and rotated reverse rectangles
            		for(k=0;k+smallwidth<=Co.getWidth();k=k+smallwidth){
            			for(l=j;l+smallheight<=Co.getHeight();l=l+smallheight){
            				//generate the one small shape and saves the vector
            				Rectangle reverse2=new Rectangle(smallheight,smallwidth,k,l,0,'i');//SIKINTI ÇIKARABİLİR
                            ++size;
                            shapes[size]=reverse2;
            			}
            		}
            	}
            }
            else if(inner instanceof Circle){
                Circle In=(Circle)inner;
                //I calculate the circles in normal issue
                int nofCircle=(int)((Co.getWidth()/(2*In.getRadius()))*(Co.getHeight()/(2*In.getRadius())));

                //this ones are for the exception
                double control_ex1=Co.getWidth()-((Co.getWidth()/(2*In.getRadius()))*2*In.getRadius())+In.getRadius();
                double control_ex2=Co.getHeight()-((Co.getHeight()/(2*In.getRadius()))*2*In.getRadius())+In.getRadius();
                double excause=In.getRadius()*SQR3+In.getRadius();

                //this part controls the exception
                if((control_ex1<3*In.getRadius()&&control_ex1>=excause)&&(control_ex2<3*In.getRadius()&&control_ex2>=excause))
                    nofCircle=nofCircle+(int)(Co.getHeight()/(2*In.getRadius())-1)+(int)(Co.getWidth()/(2*In.getRadius())-1)+1;
                else if(control_ex1<3*In.getRadius()&&control_ex1>=excause)
                    nofCircle=nofCircle+(int)((Co.getHeight()/(2*In.getRadius()))-1);
                else if(control_ex2<3*In.getRadius()&&control_ex2>=excause)
                    nofCircle=nofCircle+(int)((Co.getWidth()/(2*In.getRadius()))-1);

                int i,j;
                for(i=(int)In.getRadius();i+In.getRadius()<=Co.getWidth();i=i+(int)(2*In.getRadius())){
                    for(j=(int)In.getRadius();j+In.getRadius()<=Co.getHeight();j=j+(int)(2*In.getRadius())){
                        //generate the one small shape and saves the vector
                        Circle drawCirc=new Circle(0,0,0,'i',i,j,In.getRadius());
                        ++size;
                        shapes[size]=drawCirc;
                    }
                }
                //for the printing exception issue
                if((control_ex1<3*In.getRadius()&&control_ex1>=excause)&&(control_ex2<3*In.getRadius()&&control_ex2>=excause)){

                    int k,l;
                    double m=2*In.getRadius();
                    double n=(Co.getHeight()/(2*In.getRadius()))*2*In.getRadius()+(SQR3DIV2*In.getRadius());
                    for(k=0;k<(Co.getWidth()/(2*In.getRadius()));k++){
                        //generate the one small shape and saves the vector
                        Circle drawCirc=new Circle(0,0,0,'i',m,n,In.getRadius());
                        ++size;
                        shapes[size]=drawCirc;

                        m=m+2*In.getRadius();
                    }
                    m=(Co.getWidth()/(2*In.getRadius()))*2*In.getRadius()+(SQR3DIV2*In.getRadius());
                    n=2*In.getRadius();
                    for(l=1;l<(Co.getHeight()/(2*In.getRadius()));l++){
                        //generate the one small shape and saves the vector
                        Circle drawCirc=new Circle(0,0,0,'i',m,n,In.getRadius());
                        ++size;
                        shapes[size]=drawCirc;

                        n=n+2*In.getRadius();
                    }
                }
                else if(control_ex2<3*In.getRadius()&&control_ex2>=excause){
                    int k;
                    double m=2*In.getRadius();
                    double n=(Co.getHeight()/(2*In.getRadius()))*2*In.getRadius()+(SQR3DIV2*In.getRadius());
                    for(k=1;k<(Co.getWidth()/(2*In.getRadius()));k++){
                        //generate the one small shape and saves the vector
                        Circle drawCirc=new Circle(0,0,0,'i',m,n,In.getRadius());
                        ++size;
                        shapes[size]=drawCirc;

                        m=m+2*In.getRadius();
                    }
                }
                else if(control_ex1<3*In.getRadius()&&control_ex1>=excause){
                    int l;
                    double m=(Co.getWidth()/(2*In.getRadius()))*2*In.getRadius()+(SQR3DIV2*In.getRadius());
                    double n=2*In.getRadius();
                    for(l=1;l<(Co.getHeight()/(2*In.getRadius()));l++){
                        //generate the one small shape and saves the vector
                        Circle drawCirc=new Circle(0,0,0,'i',m,n,In.getRadius());
                        ++size;
                        shapes[size]=drawCirc;

                        n=n+2*In.getRadius();
                    }
                }
            }
            else
                throw new MyException("UNVALID SHAPE TYPE IN OPTIMALFIT");
        }
        else if(container instanceof Circle){
            Circle Co=(Circle)container;
            shapes[size]=Co;
            if(inner instanceof Circle){
                int squareWidth=(int)((2*Co.getRadius())/1.414);
                int addForTruePoint=(int)Co.getRadius()-squareWidth/2;
                Circle In=(Circle)inner;
                //I calculate the circles in normal issue
                int nofCircle=(int)((squareWidth/(2*In.getRadius()))*(squareWidth/(2*In.getRadius())));

                //this ones are for the exception
                double control_ex1=squareWidth-((squareWidth/(2*In.getRadius()))*2*In.getRadius())+In.getRadius();
                double control_ex2=squareWidth-((squareWidth/(2*In.getRadius()))*2*In.getRadius())+In.getRadius();
                double excause=In.getRadius()*SQR3+In.getRadius();

                //this part controls the exception
                if((control_ex1<3*In.getRadius()&&control_ex1>=excause)&&(control_ex2<3*In.getRadius()&&control_ex2>=excause))
                    nofCircle=nofCircle+(int)(squareWidth/(2*In.getRadius())-1)+(int)(squareWidth/(2*In.getRadius())-1)+1;
                else if(control_ex1<3*In.getRadius()&&control_ex1>=excause)
                    nofCircle=nofCircle+(int)((squareWidth/(2*In.getRadius()))-1);
                else if(control_ex2<3*In.getRadius()&&control_ex2>=excause)
                    nofCircle=nofCircle+(int)((squareWidth/(2*In.getRadius()))-1);

                int i,j;
                for(i=(int)In.getRadius();i+In.getRadius()<=squareWidth;i=i+(int)(2*In.getRadius())){
                    for(j=(int)In.getRadius();j+In.getRadius()<=squareWidth;j=j+(int)(2*In.getRadius())){
                        //generate the one small shape and saves the vector
                        Circle drawCirc=new Circle(0,0,0,'i',i+addForTruePoint,j+addForTruePoint,In.getRadius());
                        ++size;
                        shapes[size]=drawCirc;
                    }
                }
                //for the printing exception issue
                if((control_ex1<3*In.getRadius()&&control_ex1>=excause)&&(control_ex2<3*In.getRadius()&&control_ex2>=excause)){

                    int k,l;
                    double m=2*In.getRadius();
                    double n=(squareWidth/(2*In.getRadius()))*2*In.getRadius()+(SQR3DIV2*In.getRadius());
                    for(k=0;k<(squareWidth/(2*In.getRadius()));k++){
                        //generate the one small shape and saves the vector
                        Circle drawCirc=new Circle(0,0,0,'i',m+addForTruePoint,n+addForTruePoint,In.getRadius());
                        ++size;
                        shapes[size]=drawCirc;

                        m=m+2*In.getRadius();
                    }
                    m=(squareWidth/(2*In.getRadius()))*2*In.getRadius()+(SQR3DIV2*In.getRadius());
                    n=2*In.getRadius();
                    for(l=1;l<(squareWidth/(2*In.getRadius()));l++){
                        //generate the one small shape and saves the vector
                        Circle drawCirc=new Circle(0,0,0,'i',m+addForTruePoint,n+addForTruePoint,In.getRadius());
                        ++size;
                        shapes[size]=drawCirc;

                        n=n+2*In.getRadius();
                    }
                }
                else if(control_ex2<3*In.getRadius()&&control_ex2>=excause){
                    int k;
                    double m=2*In.getRadius();
                    double n=(squareWidth/(2*In.getRadius()))*2*In.getRadius()+(SQR3DIV2*In.getRadius());
                    for(k=1;k<(squareWidth/(2*In.getRadius()));k++){
                        //generate the one small shape and saves the vector
                        Circle drawCirc=new Circle(0,0,0,'i',m+addForTruePoint,n+addForTruePoint,In.getRadius());
                        ++size;
                        shapes[size]=drawCirc;

                        m=m+2*In.getRadius();
                    }
                }
                else if(control_ex1<3*In.getRadius()&&control_ex1>=excause){
                    int l;
                    double m=(squareWidth/(2*In.getRadius()))*2*In.getRadius()+(SQR3DIV2*In.getRadius());
                    double n=2*In.getRadius();
                    for(l=1;l<(squareWidth/(2*In.getRadius()));l++){
                        //generate the one small shape and saves the vector
                        Circle drawCirc=new Circle(0,0,0,'i',m+addForTruePoint,n+addForTruePoint,In.getRadius());
                        ++size;
                        shapes[size]=drawCirc;

                        n=n+2*In.getRadius();
                    }
                }
            }
            else if(inner instanceof Triangle){
                int squareWidth=(int)((2*Co.getRadius())/1.414);
                int addForTruePoint=(int)Co.getRadius()-squareWidth/2;

                Triangle In=(Triangle)inner;
            	int normal,reverse,normalNofTriWidth,reverseNofTriHeight;

            	//It calculates normal and reverse align calculates(on width and height)
            	normalNofTriWidth=(int)(squareWidth/(SQR3DIV2*In.getLateral()));
            	reverseNofTriHeight=(int)(squareWidth/(SQR3DIV2*In.getLateral()));

            	//This parts includes exception issue's triangles
            	if((squareWidth%In.getLateral())>=(In.getLateral()/2))
            		normal=(2*(squareWidth/In.getLateral()));
            	else
            		normal=(2*(squareWidth/In.getLateral()))-1;
            	normal=normal*normalNofTriWidth;

            	//This parts includes exception issue's triangles too for reverse
            	if((squareWidth%In.getLateral())>=(In.getLateral()/2))
            		reverse=(2*(squareWidth/In.getLateral()));
            	else
            		reverse=(2*(squareWidth/In.getLateral()))-1;
            	reverse=reverse*reverseNofTriHeight;

            	//Printing normal align triangles
            	if(normal>reverse){
            		double i,j;
            		for(j=0;j+(SQR3*(In.getLateral()/2.0))<=squareWidth;j=j+(SQR3*(In.getLateral()/2.0))){
            			for(i=0;i+In.getLateral()<=squareWidth;i=i+In.getLateral()){
            				//generate the one small shape and saves the vector
                            Triangle normal1=new Triangle(In.getLateral(),'i',i+addForTruePoint,j+addForTruePoint,In.getLateral()+i+addForTruePoint,j+addForTruePoint,(In.getLateral()/2.0)+i+addForTruePoint,SQR3*(In.getLateral()/2.0)+j+addForTruePoint,0,0,0);
                            ++size;
                            shapes[size]=normal1;
            			}
            		}
            		//prints reverse type triangle
            		double k,l;
            		for(l=(SQR3*(In.getLateral()/2.0));l<=squareWidth;l=l+(SQR3*(In.getLateral()/2.0))){
            			for(k=In.getLateral()/2.0;k+In.getLateral()<=squareWidth;k=k+In.getLateral()){
            				//generate the one small shape and saves the vector
                            Triangle normal2=new Triangle(In.getLateral(),'i',k+addForTruePoint,l+addForTruePoint,In.getLateral()/2.0+k+addForTruePoint,l-(SQR3*(In.getLateral()/2.0))+addForTruePoint,In.getLateral()+k+addForTruePoint,l+addForTruePoint,0,0,0);
                            ++size;
            				shapes[size]=normal2;
            			}
            		}

            	}
            	//Printing reverse align triangles
            	else{
            		//prints reverse type triangle
            		double i,j;
            		for(i=0;i+(SQR3*(In.getLateral()/2.0))<=squareWidth;i=i+(SQR3*(In.getLateral()/2.0))){
            			for(j=0;j+In.getLateral()<=squareWidth;j=j+In.getLateral()){
            				//generate the one small shape and saves the vector
                            Triangle normal3=new Triangle(In.getLateral(),'i',i+addForTruePoint,j+addForTruePoint,i+addForTruePoint,addForTruePoint+j+In.getLateral(),addForTruePoint+SQR3*(In.getLateral()/2.0)+i,(In.getLateral()/2.0)+j+addForTruePoint,0,0,0);
                            ++size;
            				shapes[size]=normal3;
            			}
            		}
            		//prints normal type triangle
            		double k,l;
            		for(l=(In.getLateral()/2.0);l+In.getLateral()<=squareWidth;l=l+In.getLateral()){
            			for(k=(SQR3*(In.getLateral()/2.0));k<=squareWidth;k=k+(SQR3*(In.getLateral()/2.0))){
            				//generate the one small shape and saves the vector
                            Triangle normal4=new Triangle(In.getLateral(),'i',k+addForTruePoint,l+addForTruePoint,k-(SQR3*(In.getLateral()/2.0))+addForTruePoint,In.getLateral()/2.0+l+addForTruePoint,k+addForTruePoint,In.getLateral()+l+addForTruePoint,0,0,0);
                            ++size;
            				shapes[size]=normal4;
            			}
            		}
            	}
            }
            else if(inner instanceof Rectangle){
                Rectangle In=(Rectangle)inner;

            	int squareWidth=(int)((2*Co.getRadius())/1.414);

            	int nofRect,addForEmpty1,addForEmpty2,temp;

            	nofRect=(squareWidth/In.getWidth())*(squareWidth/In.getHeight());
            	addForEmpty1=(((squareWidth-((squareWidth/In.getWidth())*In.getWidth()))/In.getHeight())*(squareWidth/In.getWidth()));
            	nofRect=nofRect+addForEmpty1;

            	int i,j,k,l;

            	for(i=0;i+In.getWidth()<=squareWidth;i=i+In.getWidth()){
            		for(j=0;j+In.getHeight()<=squareWidth;j=j+In.getHeight()){
            			//generate the one small shape and saves the vector
                        Rectangle normal=new Rectangle(In.getHeight(),In.getWidth(),i+(Co.getRadius()-squareWidth/2.),j+(Co.getRadius()-squareWidth/2.),0,'i');
                        ++size;
                        shapes[size]=normal;

            		}
            	}
            	for(k=i;k+In.getHeight()<=squareWidth;k=k+In.getHeight()){
            		for(l=0;l+In.getWidth()<=squareWidth;l=l+In.getWidth()){
            			//generate the one small shape and saves the vector
                        Rectangle reverse=new Rectangle(In.getWidth(),In.getHeight(),k+(Co.getRadius()-squareWidth/2.),l+(Co.getRadius()-squareWidth/2.),0,'i');
                        ++size;
                        shapes[size]=reverse;
            		}
            	}
            }
        }
        else
            throw new MyException("UNVALID SHAPE TYPE IN OPTIMALFIT");

    }


    /**
     * The area() method returns owned class's shapes's total area.
     * @return double total area returning.
     */
    public double area(){
        double total=0;
        for(int i=0;i<size;++i)
            total+=shapes[i].area();

        return total;
    }
    /**
     * The perimeter() method returns owned class's shapes's total perimeter.
     * @return double total perimeter returning.
     */
    public double perimeter(){
        double total=0;
        for(int i=0;i<size;++i)
            total+=shapes[i].perimeter();

        return total;
    }
    /**
     * The increment() method adds 1.0 all coordinates.
     * @return incremented Shape object returning.
     */
    public Shape increment(){
        inner.increment();
        container.increment();
        return this;
    }
    /**
     * The decrement() method adds 1.0 all coordinates.
     * @return incremented Shape object returning.
     */
    public Shape decrement(){
        inner.decrement();
        container.decrement();
        return this;
    }
    /**
     * The compareTo() method compares two object handled with areas.
     * @param comp get the second object for comparing.
     * @return the compare value returning.
     */
    public int compareTo(Shape comp){
        return Double.compare(area(),comp.area());
    }
    /**
     * The draw(); method draw the GUI based the object
     * @param shape object that is printed out.
     * @exception MyException if the user entered unvalid shape than throw the error.
     */
    public void draw(Graphics shape)throws MyException{
        for(int i=0;i<=size;i++){
            if(shapes[i]==null)
                throw new MyException("SHAPES IS NULL!");
            else
                shapes[i].draw(shape);
        }
    }
}
