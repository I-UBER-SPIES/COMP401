package a4jedi;

public class VerticalStackPicture extends AnyPicture implements Picture {
	Picture top;
	Picture bottom;
	
	public VerticalStackPicture(Picture top, Picture bottom){
		super(Validate.validatePicture(top).getWidth(),Validate.validatePicture(top).getHeight()+Validate.validatePicture(bottom).getHeight());
		if(top.getWidth() != bottom.getWidth()){
			throw new IllegalArgumentException("Widths don't match!");
		}
		this.top = top;
		this.bottom=bottom;
	}

	@Override
	public void setPixel(int x, int y, Pixel p) {
		// TODO Auto-generated method stub

	}

	@Override
	public Pixel getPixel(int x, int y) {
		if(y < top.getHeight()){
			return top.getPixel(x, y);
		}else{
			return bottom.getPixel(x, y-top.getHeight());
		}
	}

}
