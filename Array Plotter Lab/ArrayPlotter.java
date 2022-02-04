import javax.swing.JOptionPane;

public class ArrayPlotter
{
	/** The Array Plotter Graphical User Interface. */
	private ArrayPlotterGUI gui;
	
	/** The Color Array.  The element values indicate how to color a grid cell:
	 *  - true: Color the cell with the Drawing Color.
	 *  - false: Color the cell with the Background Color.
	 */
	private boolean[][] colorArray;
	
	
	/** Constructs an Array Plotter */
	public ArrayPlotter()
	{
		 gui = new ArrayPlotterGUI(this);
		 colorArray = null;
		 
		 
	}
	
	/** Initialize this's Color Array to a new 2D array of boolean values
	 *  with the given dimensions.
	 *  @param rows the number of rows in the new array.
	 *  @param cols the number of columns in the new array.
	 *  Postcondition: All of the Color Array's elements have the value false.
	 */
	public void initializeColorArray(int rows, int cols)
	{
		colorArray = new boolean[rows][cols];
	}

	/** Removes all objects from the grid. */
	public void onClearGridButtonClick()
	{
		for(int row = 0; row < colorArray.length; row++){
			for(int col = 0; col < colorArray[row].length; col++){
				colorArray[row][col] = false;
			}
		}
		gui.update(colorArray);
	}
	
	/** Fills in all the cells of the grid using a row-major traversal. */
	public void onRowMajorFillButtonClick()
	{
		for(int row = 0; row < colorArray.length; row++){
			for(int col = 0; col < colorArray[row].length; col++){
				colorArray[row][col] = true;
				gui.update(colorArray);
			}
		}
		
	}
	
	/** Fills in all the cells of the grid using a col-major traversal */
	public void onColMajorFillButtonClick()
	{
		for(int col = 0; col < colorArray[0].length; col++){
			for(int row = 0; row < colorArray.length; row++){
				colorArray[row][col] = true;
				gui.update(colorArray);
			}
		}
		
	}
	
	/** Fills in all the cells of the grid using a diagonal traversal */
	public void onMainDiagonalFillButtonClick()
	{
		int counter = 0;
    	for(int row = 0; row < colorArray.length; row++) {
        for(int col = 0; col < colorArray[row].length; col++)  {
            if(col == row){
            	colorArray[row][col] = true;
            	gui.update(colorArray);
            }
        }
      }
	}
	
	/** Helper method that fills in all of the cells in a row from left to right */
	private void fillRowLeftToRight(boolean[] row){
		for(int i = 0; i < row.length; i++){
			row[i] = true;
			gui.update(colorArray);
		}
	}
	
	/** Helper method that fills in all of the cells in a row from right to left */
	private void fillRowRightToLeft(boolean[] row){
		for(int i = row.length-1; i >= 0; i--){
			row[i] = true;
			gui.update(colorArray);
		}
		
	}
	
	/** Fills in all the cells of the grid using a serpentine traversal. */
	public void onSerpentineFillButtonClick()
	{
		int index = 0;
		for(boolean[] row : colorArray){
			if(index % 2 == 0){
				fillRowLeftToRight(row);
				gui.update(colorArray);
			}
			if(index % 2 == 1){
				fillRowRightToLeft(row);
				gui.update(colorArray);
			}
			index++;
		}
	}
	
	/** Fills in all the cells of the grid using a triangle fill traversal. */
	public void onMainTriangleFillButtonClick()
	{
		int counter = 0;
    	for(int row = 0; row < colorArray.length; row++) {
        for(int col = 0; col < colorArray[row].length; col++)  {
            if(col <= row){
            	colorArray[row][col] = true;
            	gui.update(colorArray);
            }
        }
      }
	}
	
	/** Fills in all the cells of the grid using a reverse col-major traversal. */
	public void onReverseColMajorFillButtonClick()
	{
		for(int col = colorArray[0].length-1; col >= 0; col--){
			for(int row = colorArray.length-1; row >= 0; row--){
				colorArray[row][col] = true;
				gui.update(colorArray);
			}
		}
	}
	
	
	/** main method that creates the grid plotter application. */
	public static void main(String[] args)
	{	
		ArrayPlotter plot = new ArrayPlotter();
	}
}
