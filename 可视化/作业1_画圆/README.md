# Java可视化画圆
总的来说，画圆是用geom或者Graphic或者shape这样的图形库，然后加到Frame里可视化；要想把圆画得更圆，就要做平滑处理
## Graphics
&emsp;&emsp;最基础的方法是用awt中的Graphics中的drawOval函数画圆。  
```java
void java.awt.Graphics.drawOval(int x, int y, int width, int height)
```
&emsp;&emsp;因为Graphics中椭圆被视为和矩形类似的，所以这里x、y不是焦点之类的，而是椭圆外接矩形的左上角坐标，width是横轴长，height是纵轴长。  
&emsp;&emsp;至于实现可视化的方法，是写一个继承Component的子类myComp，重载它的paint()函数，这样把myComp加入一个Frame中后，显示Frame的时候会自动调用myComp的paint()。（利用Graphics和Graphics2D其实绘图大致都是这样的。）
```java
class myComp extends Component{
    @Override
    public void paint(Graphics g){}
}
...
Frame f = new Frame();
f.add(new myComp());
f.setVisible(true);
```
## geom.Ellipse2D
&emsp;&emsp;drawOval用起来算坐标其实很不方便，可以使用java.awt.geom中的Ellipse2D构造，这样做的好处是它提供一个setFrameFromCenter方法，可以用中心点和一个边界点构造——对于圆来说，就是确定圆点$O(x,y)$和半径$r$，另外点就可以用$O^{'}(x+r,y+r)$表示——这样更自然一些.
```java
void java.awt.Graphics2D.setRenderingHint(Key hintKey, Object hintValue)
```
## Graphics2D
&emsp;&emsp;Graphics2D是对Graphics的升级，调用方法基本一致，除了需要在paint重载的时候要把Graphics类型参数转换成Graphics2D类型，但用Graphics2D的好处在于它有调节平滑参数的方法，可以把圆画的足够光滑，足够“圆”。
```java
void java.awt.Graphics2D.setRenderingHint(Key hintKey, Object hintValue)
```
&emsp;&emsp;这里hintKey是已经写好的数据类型，用于控制对不同对象的光滑处理，比如KEY_ANTIALIASING是反锯齿的，	KEY_COLOR_RENDERING是控制颜色渲染等等；hintValue则是Key中可选的模式，比如ON、OFF、DEFAULT等等。  
&emsp;&emsp;对一般形状最管用的效果是反锯齿，加完之后是这样的：  
![3](抗锯齿.png)
## 抗锯齿
## javafx