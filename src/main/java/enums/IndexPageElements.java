package enums;

import java.util.Arrays;
import java.util.List;

public enum IndexPageElements {

    INDEX_PAGE_ELEMENTS(4,
            Arrays.asList(
                    "To include good practices\nand ideas from successful\nEPAM project",
                    "To be flexible and\ncustomizable",
                    "To be multiplatform",
                    "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"),
            "EPAM FRAMEWORK WISHES…",
            "LOREM IPSUM DOLOR SIT AMET, " +
                    "CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. " +
                    "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO " +
                    "CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

    public int nImages;
    public List<String> benefitTexts;
    public String mainTitle;
    public String mainText;

    IndexPageElements(int nImages, List<String> benefitTexts, String mainTitle, String mainText) {
        this.nImages = nImages;
        this.benefitTexts = benefitTexts;
        this.mainTitle = mainTitle;
        this.mainText = mainText;
    }
}