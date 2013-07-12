package com.uha.client.widgets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.uha.common.Services;

@SuppressWarnings("serial")
public class ServicesPanel extends JPanel {
	
	private Map<Services, JCheckBox> checkBoxMap;
	
	private JCheckBox bloodWorkCheckBox;
	private JCheckBox ophthCheckBox;
	private JCheckBox cardCheckBox;
	private JCheckBox dentalCheckBox;
	private JCheckBox intMedCheckBox;
	private JCheckBox entCheckBox;
	private JCheckBox pediaCheckBox;
	private JCheckBox gastroCheckBox;
	private JCheckBox gyneoCheckBox;
	private JCheckBox urologyCheckBox;
	private JCheckBox psychCheckBox;
	private JCheckBox podiatryCheckBox;

	public ServicesPanel() {
		checkBoxMap = new HashMap<Services, JCheckBox>();
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				ColumnSpec.decode("6dlu"),
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("4dlu"),
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("5dlu"),
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("5dlu"),
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("5dlu"),
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("5dlu"),
				FormFactory.DEFAULT_ROWSPEC,}));
		
		
		bloodWorkCheckBox = new JCheckBox("Blood Work");
		checkBoxMap.put(Services.BLOOD, bloodWorkCheckBox);
		add(bloodWorkCheckBox, "2, 2");
		
		ophthCheckBox = new JCheckBox("Ophthalmology");
		checkBoxMap.put(Services.BLOOD, ophthCheckBox);
		add(ophthCheckBox, "4, 2");
		
		cardCheckBox = new JCheckBox("Cardiology");
		checkBoxMap.put(Services.BLOOD, cardCheckBox);
		add(cardCheckBox, "2, 4");
		
		dentalCheckBox = new JCheckBox("Dental");
		checkBoxMap.put(Services.BLOOD, dentalCheckBox);
		add(dentalCheckBox, "4, 4");
		
		intMedCheckBox = new JCheckBox("Internal Medicine");
		checkBoxMap.put(Services.BLOOD, intMedCheckBox);
		add(intMedCheckBox, "2, 6");
		
		entCheckBox = new JCheckBox("ENT");
		checkBoxMap.put(Services.BLOOD, entCheckBox);
		add(entCheckBox, "4, 6");
		
		pediaCheckBox = new JCheckBox("Pediatrics");
		checkBoxMap.put(Services.BLOOD, pediaCheckBox);
		add(pediaCheckBox, "2, 8");
		
		gastroCheckBox = new JCheckBox("Gastroenterology");
		checkBoxMap.put(Services.BLOOD, gastroCheckBox);
		add(gastroCheckBox, "4, 8");
		
		gyneoCheckBox = new JCheckBox("Gyneocology");
		checkBoxMap.put(Services.BLOOD, gyneoCheckBox);
		add(gyneoCheckBox, "2, 10");
		
		urologyCheckBox = new JCheckBox("Urology");
		checkBoxMap.put(Services.BLOOD, urologyCheckBox);
		add(urologyCheckBox, "4, 10");
		
		psychCheckBox = new JCheckBox("Psychiatry");
		checkBoxMap.put(Services.BLOOD, psychCheckBox);
		add(psychCheckBox, "2, 12");
		
		podiatryCheckBox = new JCheckBox("Podiatry");
		checkBoxMap.put(Services.BLOOD, podiatryCheckBox);
		add(podiatryCheckBox, "4, 12");
	}
	
	List<Services> getSelectedServices() {
		List<Services> selectedServices = new ArrayList<Services>();
		for (Services service : Services.values()) {
			if (checkBoxMap.get(service).isSelected()) {
				selectedServices.add(service);
			}
		}
		return selectedServices;
	}
	
	void disableServices(List<Services> disabledServices) {
		for (Services service : disabledServices) {
			checkBoxMap.get(service).setEnabled(false);
		}
	}

}
