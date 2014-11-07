package com.marshalchen.common.uimodule.imageprocessing.filter.processing;import com.marshalchen.common.uimodule.imageprocessing.filter.GroupFilter;/** * This performs a dilation on the red channel of an image, followed by an erosion of the same radius. The radius is set on initialization, with a range of 1+ pixels. This filters out smaller dark regions. * @author Chris Batt */public class ClosingFilter extends GroupFilter {	public ClosingFilter(int radius) {		DilationFilter dilation = new DilationFilter(radius);		ErosionFilter erosion = new ErosionFilter(radius);		dilation.addTarget(erosion);		erosion.addTarget(this);				registerInitialFilter(dilation);		registerTerminalFilter(erosion);	}}