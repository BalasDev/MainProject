package by.epam.project.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Activities")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExportXML {

    @XmlElement(name = "Activitie")
   public List<Export> exportData = new ArrayList<Export>();

    public List<Export> getExportData() {
        return exportData;
    }

    public void setExportData(List<Export> exportData) {
        this.exportData = exportData;
    }
}
