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

    public final String getId() {
        return this.id;
    }

    public final void setId(final String id) {
        this.id = id;
    }

    public final String getCaseNr() {
        return this.caseNr;
    }

    public final void setCaseNr(final String caseNr) {
        this.caseNr = caseNr;
    }

    public final String getEingelagert() {
        return this.eingelagert;
    }

    public final void setEingelagert(final String eingelagert) {
        this.eingelagert = eingelagert;
    }

    public final String getLieferant() {
        return this.lieferant;
    }

    public final void setLieferant(final String lieferant) {
        this.lieferant = lieferant;
    }

    public final String getKorrespondenzDatum() {
        return this.korrespondenzDatum;
    }

    public final void setKorrespondenzDatum(final String korrespondenzDatum) {
        this.korrespondenzDatum = korrespondenzDatum;
    }

    public final String getArbeitsTitel() {
        return this.arbeitsTitel;
    }

    public final void setArbeitsTitel(final String arbeitsTitel) {
        this.arbeitsTitel = arbeitsTitel;
    }

    public final String getBemerkung() {
        return this.bemerkung;
    }

    public final void setBemerkung(final String bemerkung) {
        this.bemerkung = bemerkung;
    }

    public final String getBearbeiter() {
        return this.bearbeiter;
    }

    public final void setBearbeiter(final String bearbeiter) {
        this.bearbeiter = bearbeiter;
    }
}
