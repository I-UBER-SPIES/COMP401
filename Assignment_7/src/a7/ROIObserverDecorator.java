package a7;

public interface ROIObserverDecorator extends ROIObserver {

	Region getRegion();
	ROIObserver getROIObserver();
}
