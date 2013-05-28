package Storage;

public class Entry {

    private String id;
    private String caseNr;
    private String eingelagert;
    private String lieferant;
    private String korrespondenzDatum;
    private String arbeitsTitel;
    private String bemerkung;
    private String bearbeiter;

    public String getId() {
        return this.id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getCaseNr() {
        return this.caseNr;
    }

    public void setCaseNr(final String caseNr) {
        this.caseNr = caseNr;
    }

    public String getEingelagert() {
        return this.eingelagert;
    }

    public void setEingelagert(final String eingelagert) {
        this.eingelagert = eingelagert;
    }

    public String getLieferant() {
        return this.lieferant;
    }

    public void setLieferant(final String lieferant) {
        this.lieferant = lieferant;
    }

    public String getKorrespondenzDatum() {
        return this.korrespondenzDatum;
    }

    public void setKorrespondenzDatum(final String korrespondenzDatum) {
        this.korrespondenzDatum = korrespondenzDatum;
    }

    public String getArbeitsTitel() {
        return this.arbeitsTitel;
    }

    public void setArbeitsTitel(final String arbeitsTitel) {
        this.arbeitsTitel = arbeitsTitel;
    }

    public String getBemerkung() {
        return this.bemerkung;
    }

    public void setBemerkung(final String bemerkung) {
        this.bemerkung = bemerkung;
    }

    public String getBearbeiter() {
        return this.bearbeiter;
    }

    public void setBearbeiter(final String bearbeiter) {
        this.bearbeiter = bearbeiter;
    }

    public String printAll() {
        return this.getId() + " " + this.getCaseNr() + " " + this.getEingelagert() + " " + this.getLieferant() + " "
                + this.getKorrespondenzDatum() + " " + this.getArbeitsTitel() + " " + this.getBemerkung() + " "
                + this.getBearbeiter();

    }
}
