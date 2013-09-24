package com.uha.client.widgets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.uha.common.Services;
import com.uha.core.Pair;

@SuppressWarnings("serial")
public class ServicesPanel extends JPanel {

	private Map<Services, UHACheckBox> checkBoxMap;

	private UHACheckBox bloodWorkCheckBox;
	private UHACheckBox ophthCheckBox;
	private UHACheckBox cardCheckBox;
	private UHACheckBox dentalCheckBox;
	private UHACheckBox intMedCheckBox;
	private UHACheckBox entCheckBox;
	private UHACheckBox pediaCheckBox;
	private UHACheckBox gastroCheckBox;
	private UHACheckBox gyneoCheckBox;
	private UHACheckBox urologyCheckBox;
	private UHACheckBox psychCheckBox;
	private UHACheckBox podiatryCheckBox;

	public ServicesPanel() {
		checkBoxMap = new HashMap<Services, UHACheckBox>();
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				ColumnSpec.decode("6dlu"), FormFactory.DEFAULT_COLSPEC, },
				new RowSpec[] { FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, RowSpec.decode("4dlu"),
						FormFactory.DEFAULT_ROWSPEC, RowSpec.decode("5dlu"),
						FormFactory.DEFAULT_ROWSPEC, RowSpec.decode("5dlu"),
						FormFactory.DEFAULT_ROWSPEC, RowSpec.decode("5dlu"),
						FormFactory.DEFAULT_ROWSPEC, RowSpec.decode("5dlu"),
						FormFactory.DEFAULT_ROWSPEC, }));

		bloodWorkCheckBox = new UHACheckBox(Services.BLOOD.getLabel());
		checkBoxMap.put(Services.BLOOD, bloodWorkCheckBox);
		add(bloodWorkCheckBox, "2, 2");

		ophthCheckBox = new UHACheckBox(Services.OPHTH.getLabel());
		checkBoxMap.put(Services.OPHTH, ophthCheckBox);
		add(ophthCheckBox, "4, 2");

		cardCheckBox = new UHACheckBox(Services.CARDIO.getLabel());
		checkBoxMap.put(Services.CARDIO, cardCheckBox);
		add(cardCheckBox, "2, 4");

		dentalCheckBox = new UHACheckBox(Services.DENTAL.getLabel());
		checkBoxMap.put(Services.DENTAL, dentalCheckBox);
		add(dentalCheckBox, "4, 4");

		intMedCheckBox = new UHACheckBox(Services.INTMED.getLabel());
		checkBoxMap.put(Services.INTMED, intMedCheckBox);
		add(intMedCheckBox, "2, 6");

		entCheckBox = new UHACheckBox(Services.ENT.getLabel());
		checkBoxMap.put(Services.ENT, entCheckBox);
		add(entCheckBox, "4, 6");

		pediaCheckBox = new UHACheckBox(Services.PEDIA.getLabel());
		checkBoxMap.put(Services.PEDIA, pediaCheckBox);
		add(pediaCheckBox, "2, 8");

		gastroCheckBox = new UHACheckBox(Services.GASTRO.getLabel());
		checkBoxMap.put(Services.GASTRO, gastroCheckBox);
		add(gastroCheckBox, "4, 8");

		gyneoCheckBox = new UHACheckBox(Services.GYNEO.getLabel());
		checkBoxMap.put(Services.GYNEO, gyneoCheckBox);
		add(gyneoCheckBox, "2, 10");

		urologyCheckBox = new UHACheckBox(Services.UROLOGY.getLabel());
		checkBoxMap.put(Services.UROLOGY, urologyCheckBox);
		add(urologyCheckBox, "4, 10");

		psychCheckBox = new UHACheckBox(Services.PSYCH.getLabel());
		checkBoxMap.put(Services.PSYCH, psychCheckBox);
		add(psychCheckBox, "2, 12");

		podiatryCheckBox = new UHACheckBox(Services.PODIA.getLabel());
		checkBoxMap.put(Services.PODIA, podiatryCheckBox);
		add(podiatryCheckBox, "4, 12");
	}

	public List<Services> getSelectedServices() {
		List<Services> selectedServices = new ArrayList<Services>();
		for (Services service : Services.values()) {
			if (checkBoxMap.get(service).isSelected()) {
				selectedServices.add(service);
			}
		}
		return selectedServices;
	}

	public void disableServices(List<Pair<Services, Boolean>> list) {
		clear();
		for (Pair<Services, Boolean> service : list) {
			if (service.getSecond()) {
				checkBoxMap.get(service.getFirst()).setEnabled(false);
			}
			else checkBoxMap.get(service.getFirst()).setSelected(true);
		}
	}

	public void clear() {
		for (Services service : Services.values()) {
			checkBoxMap.get(service).setSelected(false);
			checkBoxMap.get(service).setEnabled(true);

		}
	}

	public void makeExclusive() {
		for (Services service : Services.values()) {
			checkBoxMap.get(service).makeExclusive(this);
		}
	}

	public void deselectAllExcept(UHACheckBox uhaCheckBox) {
		for (Services service : Services.values()) {
			if (!checkBoxMap.get(service).equals(uhaCheckBox)) {
				checkBoxMap.get(service).setSelected(false);
			}
		}

	}

}
