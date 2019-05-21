package be.vdab.frida.controllers;

import be.vdab.frida.be.vdab.frida.domain.Saus;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

// enkele imports
public class SausControllerTest {
    private SausController controller;
    @Before
    public void before() {
        controller = new SausController();
    }
    @Test
    public void sauzenGebruiktDeThymeleafPaginaSauzen() {
        assertThat(controller.sauzen().getViewName()).isEqualTo("sauzen");
    }
    @Test
    public void sauzenGeeftSauzenDoorAanDeThymeleafPagina() {
        assertThat(controller.sauzen().getModel().get("sauzen") instanceof Saus[])
                .isTrue();
    }
    @Test
    public void sausGebruiktDeThymeleafPaginaSaus() {
        assertThat(controller.saus(3L).getViewName()).isEqualTo("saus");
    }
    @Test
    public void sausGeeftGevondenSausDoorAanDeThymeleafPagina() {
        Saus saus = (Saus) controller.saus(3L).getModel().get("saus");
        assertThat(saus.getNummer()).isEqualTo(3L);
    }
    @Test
    public void sausGeeftOnbestaandeSausNietDoorAanDeThymeleafPagina() {
        assertThat(controller.saus(-3L).getModel()).doesNotContainKey("saus");
    }
}