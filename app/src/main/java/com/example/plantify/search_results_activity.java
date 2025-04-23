package com.example.plantify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.HapticFeedbackConstants;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class search_results_activity extends AppCompatActivity {

    LinearLayout main;
    LinearLayout h_bhp, h_jmp, h_plp, h_fbp, h_lbp, h_stp, h_pgp, h_mpg, h_pp, h_bwp, h_arp, h_apbp, h_bpx, h_bpp, h_flp, h_vjmp;
    LinearLayout dmm, hwp, dpw, fpw, cps, pis, ss, ws;
    AppCompatButton h_bhp_cart_click, h_jmp_cart_click, h_plp_cart_click, h_fbp_cart_click, h_lbp_cart_click, h_stp_cart_click, h_pgp_cart_click, h_mpg_cart_click, h_pp_cart_click, h_bwp_cart_click, h_arp_cart_click, h_apbp_cart_click, h_bpx_cart_click, h_bpp_cart_click, h_flp_cart_click, h_vjmp_cart_click;
    AppCompatButton dmm_cart_click, hwp_cart_click, dpw_cart_click, fpw_cart_click, cps_cart_click, pis_cart_click, ss_cart_click, ws_cart_click;
    LinearLayout p_gwp,p_owp,p_rwwp,p_rcp,p_cagcp,p_stp,p_tfbcp,p_tffcp,p_tccp,p_vep;
    AppCompatButton p_gwp_cart_click, p_owp_cart_click, p_rwwp_cart_click, p_rcp_cart_click, p_cagcp_cart_click, p_stp_cart_click, p_tfbcp_cart_click, p_tffcp_cart_click, p_tccp_cart_click, p_vep_cart_click;
    LinearLayout s_amaranths,s_beetroots,s_broccolis,s_capsicums,s_corianders,s_fenugreek,s_greenchilli,s_greencucumber,s_okras,s_redamaranthus,s_spinch,s_tomatos;
    AppCompatButton s_amaranths_cart_click, s_beetroots_cart_click, s_broccolis_cart_click, s_capsicums_cart_click, s_corianders_cart_click, s_fenugreek_cart_click, s_greenchilli_cart_click, s_greencucumber_cart_click, s_okras_cart_click, s_redamaranthus_cart_click, s_spinch_cart_click, s_tomatos_cart_click;

    static ArrayList<String> name = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        main = findViewById(R.id.main);

        h_bhp = findViewById(R.id.h_bhp);
        h_jmp = findViewById(R.id.h_jmp);
        h_plp = findViewById(R.id.h_plp);
        h_fbp = findViewById(R.id.h_fbp);
        h_lbp = findViewById(R.id.h_lbp);
        h_stp = findViewById(R.id.h_stp);
        h_pgp = findViewById(R.id.h_pgp);
        h_mpg = findViewById(R.id.h_mpg);
        h_pp = findViewById(R.id.h_pp);
        h_bwp = findViewById(R.id.h_bwp);
        h_arp = findViewById(R.id.h_arp);
        h_apbp = findViewById(R.id.h_apbp);
        h_bpx = findViewById(R.id.h_bpx);
        h_bpp = findViewById(R.id.h_bpp);
        h_flp = findViewById(R.id.h_flp);
        h_vjmp = findViewById(R.id.h_vjmp);
        h_bhp_cart_click = findViewById(R.id.h_bhp_cart_click);
        h_jmp_cart_click = findViewById(R.id.h_jpm_cart_click);
        h_plp_cart_click = findViewById(R.id.h_plp_cart_click);
        h_fbp_cart_click = findViewById(R.id.h_fbp_cart_click);
        h_lbp_cart_click = findViewById(R.id.h_lbp_cart_click);
        h_stp_cart_click = findViewById(R.id.h_stp_cart_click);
        h_pgp_cart_click = findViewById(R.id.h_pgp_cart_click);
        h_mpg_cart_click = findViewById(R.id.h_mpg_cart_click);
        h_pp_cart_click = findViewById(R.id.h_pp_cart_click);
        h_bwp_cart_click = findViewById(R.id.h_bwp_cart_click);
        h_arp_cart_click = findViewById(R.id.h_arp_cart_click);
        h_apbp_cart_click = findViewById(R.id.h_apbp_cart_click);
        h_bpx_cart_click = findViewById(R.id.h_bpx_cart_click);
        h_bpp_cart_click = findViewById(R.id.h_bpp_cart_click);
        h_flp_cart_click = findViewById(R.id.h_flp_cart_click);
        h_vjmp_cart_click = findViewById(R.id.h_vjmp_cart_click);

        dmm = findViewById(R.id.dmm);
        hwp = findViewById(R.id.hwp);
        dpw = findViewById(R.id.dpw);
        fpw = findViewById(R.id.fpw);
        cps = findViewById(R.id.cps);
        pis = findViewById(R.id.pis);
        ss = findViewById(R.id.ss);
        ws = findViewById(R.id.ws);
        dmm_cart_click = findViewById(R.id.dmm_cart_click);
        hwp_cart_click = findViewById(R.id.hwp_cart_click);
        dpw_cart_click = findViewById(R.id.dpw_cart_click);
        fpw_cart_click = findViewById(R.id.fpw_cart_click);
        cps_cart_click = findViewById(R.id.cps_cart_click);
        pis_cart_click = findViewById(R.id.pis_cart_click);
        ss_cart_click = findViewById(R.id.ss_cart_click);
        ws_cart_click = findViewById(R.id.ws_cart_click);

        p_gwp = findViewById(R.id.p_gwp);
        p_owp = findViewById(R.id.p_owp);
        p_rwwp = findViewById(R.id.p_rwwp);
        p_rcp = findViewById(R.id.p_rcp);
        p_cagcp = findViewById(R.id.p_cagcp);
        p_stp = findViewById(R.id.p_stp);
        p_tfbcp = findViewById(R.id.p_tfbcp);
        p_tffcp = findViewById(R.id.p_tffcp);
        p_tccp = findViewById(R.id.p_tccp);
        p_vep = findViewById(R.id.p_vep);
        p_gwp_cart_click = findViewById(R.id.p_gwp_cart_click);
        p_owp_cart_click = findViewById(R.id.p_owp_cart_click);
        p_rwwp_cart_click = findViewById(R.id.p_rwwp_cart_click);
        p_rcp_cart_click = findViewById(R.id.p_rcp_cart_click);
        p_cagcp_cart_click = findViewById(R.id.p_cagcp_cart_click);
        p_stp_cart_click = findViewById(R.id.p_stp_cart_click);
        p_tfbcp_cart_click = findViewById(R.id.p_tfbcp_cart_click);
        p_tffcp_cart_click = findViewById(R.id.p_tffcp_cart_click);
        p_tccp_cart_click = findViewById(R.id.p_tccp_cart_click);
        p_vep_cart_click = findViewById(R.id.p_vep_cart_click);

        s_amaranths = findViewById(R.id.s_amaranths);
        s_beetroots = findViewById(R.id.s_beetroots);
        s_broccolis = findViewById(R.id.s_broccolis);
        s_capsicums = findViewById(R.id.s_capsicums);
        s_corianders = findViewById(R.id.s_corianders);
        s_fenugreek = findViewById(R.id.s_fenugreeks);
        s_greenchilli = findViewById(R.id.s_greenchillis);
        s_greencucumber = findViewById(R.id.s_greencucumbers);
        s_okras = findViewById(R.id.s_okras);
        s_redamaranthus = findViewById(R.id.s_redamaranthuss);
        s_spinch = findViewById(R.id.s_spinchs);
        s_tomatos = findViewById(R.id.s_tomatos);
        s_amaranths_cart_click = findViewById(R.id.s_amaranths_cart_click);
        s_beetroots_cart_click = findViewById(R.id.s_beetroots_cart_click);
        s_broccolis_cart_click = findViewById(R.id.s_broccolis_cart_click);
        s_capsicums_cart_click = findViewById(R.id.s_capsicums_cart_click);
        s_corianders_cart_click = findViewById(R.id.s_corianders_cart_click);
        s_fenugreek_cart_click = findViewById(R.id.s_fenugreek_cart_click);
        s_greenchilli_cart_click = findViewById(R.id.s_greenchillis_cart_click);
        s_greencucumber_cart_click = findViewById(R.id.s_greencucumbers_cart_click);
        s_okras_cart_click = findViewById(R.id.s_okras_cart_click);
        s_redamaranthus_cart_click = findViewById(R.id.s_redamaranthuss_cart_click);
        s_spinch_cart_click = findViewById(R.id.s_spinchs_cart_click);
        s_tomatos_cart_click = findViewById(R.id.s_tomatos_cart_click);

        name.add("Broken Heart Plant");
        name.add("Jade Plant Mini");
        name.add("Peace Lily Plant");
        name.add("Ficus Bonsai Plant");
        name.add("Lucky Bamboo Plant");
        name.add("Stormanthe Triostar Plant");
        name.add("Peperomia Green Plant");
        name.add("Money Plant Golden");
        name.add("Peacock Plant");
        name.add("Brazilian Wood Plant");
        name.add("Aglaonema Red Plant");
        name.add("Aglaonema Pink Beauty Plant");
        name.add("Bamboo Palm XL");
        name.add("Bamboo Palm Plant");
        name.add("Fiddle Leaf Fig Plant");
        name.add("Variegated Jade Mini Plant");

        name.add("Dom Metallic Mister");
        name.add("Hydra Watering Pitcher");
        name.add("Double Prong Weeder");
        name.add("Five Prong Weeder");
        name.add("Curve Pruning Saw - 33 Cm");
        name.add("Plastic Impulse Sprinkler");
        name.add("Sprinkler Stand");
        name.add("Watermatic Stake");

        name.add("Gradient Wooden Planter");
        name.add("Orbit Wooden Planter");
        name.add("Ridged Waves Wooden Pot");
        name.add("Roma Ceramic Pot");
        name.add("Cats Are Gods Ceramic Planter");
        name.add("Sienna Terracotta Pots");
        name.add("Tulip Fantasy Bowl Ceramic Planter");
        name.add("Tulip Fantasy Flat Ceramic Planter");
        name.add("Twilight Clouds Ceramic Planter");
        name.add("Verona Eco Planter");

        name.add("Amaranth Seeds");
        name.add("Beetroot Seeds");
        name.add("Broccoli Seeds");
        name.add("Capsicum Seeds");
        name.add("Coriander Seeds");
        name.add("Fenugreek Seeds");
        name.add("Green Chilli Seeds");
        name.add("Green Cucumber Seeds");
        name.add("Okra Seeds");
        name.add("Red Amaranthus Seeds");
        name.add("Spinch Seeds");
        name.add("Tomato Seed");

        h_bhp.setVisibility(View.GONE);
        h_jmp.setVisibility(View.GONE);
        h_plp.setVisibility(View.GONE);
        h_fbp.setVisibility(View.GONE);
        h_lbp.setVisibility(View.GONE);
        h_stp.setVisibility(View.GONE);
        h_pgp.setVisibility(View.GONE);
        h_mpg.setVisibility(View.GONE);
        h_pp.setVisibility(View.GONE);
        h_bwp.setVisibility(View.GONE);
        h_arp.setVisibility(View.GONE);
        h_apbp.setVisibility(View.GONE);
        h_bpx.setVisibility(View.GONE);
        h_bpp.setVisibility(View.GONE);
        h_flp.setVisibility(View.GONE);
        h_vjmp.setVisibility(View.GONE);

        dmm.setVisibility(View.GONE);
        hwp.setVisibility(View.GONE);
        dpw.setVisibility(View.GONE);
        fpw.setVisibility(View.GONE);
        cps.setVisibility(View.GONE);
        pis.setVisibility(View.GONE);
        ss.setVisibility(View.GONE);
        ws.setVisibility(View.GONE);

        p_gwp.setVisibility(View.GONE);
        p_owp.setVisibility(View.GONE);
        p_rwwp.setVisibility(View.GONE);
        p_rcp.setVisibility(View.GONE);
        p_cagcp.setVisibility(View.GONE);
        p_stp.setVisibility(View.GONE);
        p_tfbcp.setVisibility(View.GONE);
        p_tffcp.setVisibility(View.GONE);
        p_tccp.setVisibility(View.GONE);
        p_vep.setVisibility(View.GONE);

        s_amaranths.setVisibility(View.GONE);
        s_beetroots.setVisibility(View.GONE);
        s_broccolis.setVisibility(View.GONE);
        s_capsicums.setVisibility(View.GONE);
        s_corianders.setVisibility(View.GONE);
        s_fenugreek.setVisibility(View.GONE);
        s_greenchilli.setVisibility(View.GONE);
        s_greencucumber.setVisibility(View.GONE);
        s_okras.setVisibility(View.GONE);
        s_redamaranthus.setVisibility(View.GONE);
        s_spinch.setVisibility(View.GONE);
        s_tomatos.setVisibility(View.GONE);


        h_bhp.setOnClickListener(v -> {
            String name = "Broken Heart Plant";
            int price = 299;
            String description = "One of the most popular houseplants, and our all-time bestseller, this easy-growing plant with its heart-shaped leaves is loved for its beautiful fenestrations. Quick to grow with delicate trailing vines that can be styled for every space, the Philodendron broken heart is the monstera charm you want to add to your home if you don't have the space for the huge monstera. Scientifically known as the Monstera adansonii, this broken heart plant thrives indoors in bright indirect light and with very little care.";
            RedirectProduct(R.drawable.broken_heart_plant_2,name,price,description);
        });

        h_jmp.setOnClickListener(v -> {
            String name = "Jade Plant Mini";
            int price = 279;
            String description = "An easy-to-care-for succulent, the Crassula Green Mini boasts lush foliage that enhances any room. Its coin-like round plump leaves are considered lucky in Feng Shui.";
            RedirectProduct(R.drawable.jade_mini_plats,name,price,description);
        });

        h_plp.setOnClickListener(v -> {
            String name = "Peace Lily Plant";
            int price = 929;
            String description = "Known for its elegant white blooms and lush green leaves, the Peace Lily is a popular houseplant that purifies indoor air. It thrives in low to medium light conditions and prefers consistently moist soil.";
            RedirectProduct(R.drawable.peace_lily_plant,name,price,description);
        });

        h_fbp.setOnClickListener(v -> {
            String name = "Ficus Bonsai Plant";
            int price = 949;
            String description = "A miniature version of the traditional Ficus tree, this Bonsai adds a touch of tranquility to indoor spaces. It requires bright indirect light and regular watering to maintain its shape and health.";
            RedirectProduct(R.drawable.ficus_bonsai_plant,name,price,description);
        });

        h_lbp.setOnClickListener(v -> {
            String name = "Lucky bamboo Plant";
            int price = 349;
            String description = "Symbolizing good fortune and prosperity, the Lucky Bamboo is easy to grow and can thrive in water or soil. It prefers indirect light and adds an elegant touch to any decor.";
            RedirectProduct(R.drawable.lucky_bamboo_plant,name,price,description);
        });

        h_stp.setOnClickListener(v -> {
            String name = "Stormanthe Triostar Plant";
            int price = 349;
            String description = "This plant is known for its striking foliage, featuring a blend of green, white, and pink colors. It prefers bright, indirect light and high humidity levels to maintain its vibrant leaves.";
            RedirectProduct(R.drawable.stromanthe_triostar_plant,name,price,description);
        });

        h_pgp.setOnClickListener(v -> {
            String name = "Peperomia Green Plant";
            int price = 279;
            String description = "A compact houseplant with thick, green leaves, the Peperomia is low-maintenance and ideal for indoor settings. It thrives in moderate light and requires minimal watering.";
            RedirectProduct(R.drawable.peperomia_green_plant,name,price,description);
        });

        h_mpg.setOnClickListener(v -> {
            String name = "Money Plant Golden";
            int price = 279;
            String description = "Also known as Golden Pothos, this plant is renowned for its trailing vines and heart-shaped leaves with golden variegation. It’s hardy, tolerates low light, and is believed to attract wealth and prosperity.";
            RedirectProduct(R.drawable.money_plant_golden,name,price,description);
        });

        h_pp.setOnClickListener(v -> {
            String name = "Peacock Plant";
            int price = 699;
            String description = "Featuring decorative leaves with intricate patterns resembling a peacock’s tail, this plant prefers low to medium light and high humidity. It’s a stunning addition to any indoor plant collection.";
            RedirectProduct(R.drawable.peacock_plant,name,price,description);
        });

        h_bwp.setOnClickListener(v -> {
            String name = "Brazilian Wood Plant";
            int price = 639;
            String description = "Also known as Dracaena fragrans, this plant has broad, arching leaves and is known for its air-purifying qualities. It thrives in low to medium light and requires moderate watering.";
            RedirectProduct(R.drawable.brazilian_wood_plant,name,price,description);
        });

        h_arp.setOnClickListener(v -> {
            String name = "Aglaonema Red Plant";
            int price = 749;
            String description = "This plant stands out with its vibrant red and green leaves. It’s easy to care for, tolerates low light conditions, and adds a pop of color to indoor spaces.";
            RedirectProduct(R.drawable.aglaonema_red_plant,name,price,description);
        });

        h_apbp.setOnClickListener(v -> {
            String name = "Aglaonema Pink Beauty Plant";
            int price = 714;
            String description = "Known for its attractive pink and green foliage, this plant is both decorative and low-maintenance. It prefers indirect light and regular watering.";
            RedirectProduct(R.drawable.aglaonema_pink_beauty_plant,name,price,description);
        });

        h_bpx.setOnClickListener(v -> {
            String name = "Bamboo Palm XL";
            int price = 857;
            String description = "A larger variety of the Bamboo Palm, this plant adds a tropical feel to interiors. It’s effective in purifying indoor air and thrives in low to medium light conditions.";
            RedirectProduct(R.drawable.bamboo_palm_xl,name,price,description);
        });

        h_bpp.setOnClickListener(v -> {
            String name = "Bamboo Palm Plant";
            int price = 899;
            String description = "A compact version of the Bamboo Palm, ideal for smaller spaces. It requires low to medium light and regular watering to keep the soil moist.";
            RedirectProduct(R.drawable.bamboo_palm_plant,name,price,description);
        });

        h_flp.setOnClickListener(v -> {
            String name = "Fiddle Leaf Fig Plant";
            int price = 1199;
            String description = "Known for its large, violin-shaped leaves, this plant is a popular choice for modern interiors. It requires bright, indirect light and consistent watering.";
            RedirectProduct(R.drawable.fiddle_leaf_fig_plant,name,price,description);
        });

        h_vjmp.setOnClickListener(v -> {
            String name = "Variegated Jade Mini Plant";
            int price = 1140;
            String description = "A succulent with fleshy, variegated leaves featuring shades of green and cream. It’s easy to care for, requiring bright light and minimal watering.";
            RedirectProduct(R.drawable.variegated_jade_mini_plant,name,price,description);
        });

        h_bhp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.broken_heart_plant_2, "Broken Heart Plant", 299, "Small", 1);
        });


        h_jmp_cart_click.setOnClickListener(v -> {
            int currentCount = cart_item.count;
            onCartClick(R.drawable.jade_mini_plats, "Jade Plant Mini", 279, "Small", 1);
        });

        h_plp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.peace_lily_plant, "Peace Lily Plant", 929, "Small", 1);
        });

        h_fbp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.ficus_bonsai_plant, "Ficus Bonsai Plant", 949, "Small", 1);
        });

        h_lbp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.lucky_bamboo_plant, "Lucky Bamboo Plant", 349, "Small", 1);
        });

        h_stp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.stromanthe_triostar_plant, "Stormanthe Triostar Plant", 349, "Small", 1);
        });

        h_pgp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.peperomia_green_plant, "Peperomia Green Plant", 279, "Small", 1);
        });

        h_mpg_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.money_plant_golden, "Money Plant Golden", 279, "Small", 1);
        });

        h_pp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.peacock_plant, "Peacock Plant", 699, "Small", 1);
        });

        h_bwp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.brazilian_wood_plant, "Brazilian Wood Plant", 639, "Small", 1);
        });

        h_arp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.aglaonema_red_plant, "Aglaonema Red Plant", 749, "Small", 1);
        });

        h_apbp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.aglaonema_pink_beauty_plant, "Aglaonema Pink Beauty Plant", 714, "Small", 1);
        });

        h_bpx_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.bamboo_palm_xl, "Bamboo Palm XL", 857, "Small", 1);
        });

        h_bpp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.bamboo_palm_plant, "Bamboo Palm Plant", 899, "Small", 1);
        });

        h_flp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.fiddle_leaf_fig_plant, "Fiddle Leaf Fig Plant", 1199, "Small", 1);
        });

        h_vjmp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.variegated_jade_mini_plant, "Variegated Jade Mini Plant", 1140, "Small", 1);
        });

        dmm.setOnClickListener(v -> {
            String name = "Dom Metallic Mister";
            int price = 859;
            String description = "A 0.5-litre watering can, essential for home or office gardeners. Its size is perfect for spritzing small indoor plants without spilling onto nearby surfaces, and it also serves as an attractive decor piece.";
            RedirectProduct(R.drawable.dom_metallic_mister,name,price,description);
        });

        hwp.setOnClickListener(v -> {
            String name = "Hydra Watering Pitcher";
            int price = 829;
            String description = "An ergonomically designed premium watering jug, ideal for easily watering indoor and outdoor plants without stress.";
            RedirectProduct(R.drawable.hydra_watering_pitcher,name,price,description);
        });

        dpw.setOnClickListener(v -> {
            String name = "Double Prong Weeder";
            int price = 399;
            String description = "An upgraded version of the Single Prong Weeder, this tool is used for weeding, small root removal, efficiently loosening soil, and digging holes to sow seeds. It features a wooden handle for a firm grip and is perfectly sized for flower beds and small vegetable gardens.";
            RedirectProduct(R.drawable.double_prong_weeder,name,price,description);
        });

        fpw.setOnClickListener(v -> {
            String name = "Five Prong Weeder";
            int price = 350;
            String description = "This tool comes with five metal prongs and a wooden handle, making it suitable for comfortably turning soil and cleaning leaves from the garden. The product height is approximately 33 cm.";
            RedirectProduct(R.drawable.five_prong_weeder,name,price,description);
        });

        cps.setOnClickListener(v -> {
            String name = "Curve Pruning Saw - 33 Cm";
            int price = 599;
            String description = "The Pyramid Curve Pruning Saw features a double-edged 33 cm blade of excellent quality with a rubber grip for comfortable and firm handling. It’s popular among garden enthusiasts for cutting small branches, limbs, and trees up to 120 mm in diameter. ";
            RedirectProduct(R.drawable.curve_pruning_saw,name,price,description);
        });

        pis.setOnClickListener(v -> {
            String name = "Plastic Impulse Sprinkler";
            int price = 599;
            String description = "The Pyramid Plastic Sprinkler is ideal for watering medium-sized lawns. It has an adjustable shower head that covers a radius of 15 to 20 square feet. The body is made of plastic. ";
            RedirectProduct(R.drawable.plastic_impulse_sprinkler,name,price,description);
        });

        ss.setOnClickListener(v -> {
            String name = "Sprinkler Stand";
            int price = 599;
            String description = "Primarily used as an attachment for the Concorde Brass G2 and G3 sprinkler heads, this stand is made of mild steel with brass components. It offers dual compatibility for both sprinkler types. ";
            RedirectProduct(R.drawable.sprinkler_stand,name,price,description);
        });

        ws.setOnClickListener(v -> {
            String name = "Watermatic Stack";
            int price = 529;
            String description = " An automatic watering system suitable for both indoor and outdoor plants. The Watermatic Stake is easy to use and install, providing consistent watering for your garden throughout the year. ";
            RedirectProduct(R.drawable.watermatic_stake,name,price,description);
        });

        dmm_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.dom_metallic_mister,"Dom Metallic Mister",859,"Small",1);
        });

        hwp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.hydra_watering_pitcher,"Hydra Watering Pitcher",829,"Samll",1);
        });

        dpw_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.double_prong_weeder,"Double Prong Weeder",399,"Samll",1);
        });

        fpw_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.five_prong_weeder,"Five Prong Weeder",350,"Samll",1);
        });

        cps_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.curve_pruning_saw,"Curve Pruning Saw - 33 Cm",599,"Samll",1);
        });

        pis_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.plastic_impulse_sprinkler,"Plastic Impulse Sprinkler",599,"Samll",1);
        });

        ss_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.sprinkler_stand,"Sprinkler Stand",599,"Samll",1);
        });

        ws_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.watermatic_stake,"Watermatic Stake",529,"Samll",1);
        });

        p_gwp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.gradient_wooden_planter,"Gradient Wooden Planter",479,"This Gradient Wooden Planter features a natural wood finish with a smooth gradient effect, adding an earthy charm to any space. Perfect for indoor plants, it blends rustic elegance with modern aesthetics.");
            }
        });

        p_owp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.orbit_wooden_planter,"Orbit Wooden Planter",499,"The Orbit Wooden Planter features a smooth, rounded design with a rich wooden texture, adding a natural charm to any space. Perfect for showcasing vibrant plants, it blends elegance with simplicity.");
            }
        });

        p_rwwp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.ridged_waves_wooden_pot,"Ridged Waves Wooden Pot",829,"The Ridged Waves Wooden Pot showcases an artistic wavy texture, adding a modern yet earthy touch. Its unique design enhances the beauty of any plant, making it a perfect decor piece.");
            }
        });

        p_rcp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.roma_ceramic_pot,"Roma Ceramic Pot",899,"Introducing the exquisite Roma Pot, a stunning ceramic masterpiece inspired by the timeless beauty of old Roman architecture. Reminiscent of majestic pillars, this unique pot brings an air of elegance and grandeur to your indoor or outdoor space.");
            }
        });

        p_cagcp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.cats_are_gods_ceramic_planter,"Cats Are Gods Ceramic Planter",1289,"The stunning ceramic planters are hand-crafted with the finest clay, locally sourced from Hyderabad and Andhra Pradesh. These beautiful planters are built to last and promise to stay with your plants for more than 20 years without fading, chipping or losing their charm. The ceramic is skillfully baked and vitrified at 1200°C, giving it a stronger built and a longer-lasting life.");
            }
        });

        p_stp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.sienna_terracotta_pots,"Sienna Terracotta Pots",1099,"The Sienna Terracotta Set of 3 Pots brings you three premium pots in aesthetic colors, adorned with elegant designs. These pots are sturdy, strong, and durable, making them the perfect companions for your plants. Find luxury and convenience all in one with these stunning terracotta pots.");
            }
        });

        p_tfbcp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.tulip_fantasy_bowl_ceramic_planter,"Tulip Fantasy Bowl Ceramic Planter",879,"Our tulip fantasy planter is beautiful in its simplicity. The minimalist design with carefully handcrafted shape means its the best fit for your plants while also elevating the decor of your home. Made of premium grade ceramic, the planter sports the silkiest glaze you will ever come across in planters. ");
            }
        });

        p_tffcp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.tulip_fantasy_flat_ceramic_planter,"Tulip Fantasy Flat Ceramic Planter",839,"Our tulip fantasy planter is beautiful in its simplicity. The minimalist design with carefully handcrafted shape means its the best fit for your plants while also elevating the decor of your home. Made of premium grade ceramic, the planter sports the silkiest glaze you will ever come across in planters. ");
            }
        });

        p_tccp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.twilight_clouds_ceramic_planter,"Twilight Clouds Ceramic Planter", 699,"The stunning ceramic planters are hand-crafted with the finest clay, locally sourced from Hyderabad and Andhra Pradesh. These beautiful planters are built to last and promise to stay with your plants for more than 20 years without fading, chipping or losing their charm. ");
            }
        });

        p_vep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.verona_eco_planter,"Verona Eco Planter",699,"Elevate your indoor décor with the Verona Eco Series planters, stylish and functional additions that seamlessly blend eco-friendly materials with contemporary design. Shop these stunning planters in different size in the color of your choice! Why get one when you can get them all?");
            }
        });
        p_gwp_cart_click.setOnClickListener(v -> onCartClick(R.drawable.gradient_wooden_planter, "Gradient Wooden Planter", 479, "Small", 1));
        p_owp_cart_click.setOnClickListener(v -> onCartClick(R.drawable.orbit_wooden_planter, "Orbit Wooden Planter", 499, "Small", 1));
        p_rwwp_cart_click.setOnClickListener(v -> onCartClick(R.drawable.ridged_waves_wooden_pot, "Ridged Waves Wooden Pot", 829, "Small", 1));
        p_rcp_cart_click.setOnClickListener(v -> onCartClick(R.drawable.roma_ceramic_pot, "Roma Ceramic Pot", 899, "Small", 1));
        p_cagcp_cart_click.setOnClickListener(v -> onCartClick(R.drawable.cats_are_gods_ceramic_planter, "Cats Are Gods Ceramic Planter", 1289, "Small", 1));
        p_stp_cart_click.setOnClickListener(v -> onCartClick(R.drawable.sienna_terracotta_pots, "Sienna Terracotta Pots", 1099, "Small", 1));
        p_tfbcp_cart_click.setOnClickListener(v -> onCartClick(R.drawable.tulip_fantasy_bowl_ceramic_planter, "Tulip Fantasy Bowl Ceramic Planter", 879, "Small", 1));
        p_tffcp_cart_click.setOnClickListener(v -> onCartClick(R.drawable.tulip_fantasy_flat_ceramic_planter, "Tulip Fantasy Flat Ceramic Planter", 839, "Small", 1));
        p_tccp_cart_click.setOnClickListener(v -> onCartClick(R.drawable.twilight_clouds_ceramic_planter, "Twilight Clouds Ceramic Planter", 699, "Small", 1));
        p_vep_cart_click.setOnClickListener(v -> onCartClick(R.drawable.verona_eco_planter, "Verona Eco Planter", 699, "Small", 1));

        s_amaranths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "Amaranth Seeds";
                int price = 499;
                String description = "Amaranth is known for its rapid growth, quick rejuvenation after each harvest, and high yield in a short time. It is highly efficient at photosynthesis and thrives even in adverse environmental conditions.";
                RedirectProduct(R.drawable.amaranth_seeds,name,price,description);
            }
        });

        s_beetroots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "Beetroot Seeds";
                int price = 499;
                String description = "These open-pollinated, 100% organic seeds are designed to provide authentic taste and superior quality harvests compared to commonly found seeds.";
                RedirectProduct(R.drawable.beetroot_seeds,name,price,description);
            }
        });

        s_broccolis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "Broccoli Seeds";
                int price = 499;
                String description = "Broccoli is relatively easy to grow and can thrive in various climates. As a cool-season crop, it’s ideal for fall or early spring planting, yielding a bountiful harvest with minimal care in just a few months.";
                RedirectProduct(R.drawable.broccoli_seeds,name,price,description);
            }
        });

        s_capsicums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "Capsicum Seeds";
                int price = 499;
                String description = "Capsicum plants take approximately 55-60 days from seed to harvest-ready peppers. They sprout in 14-18 days, grow steadily, and begin flowering in about two months. With proper care—including ample sunlight, water, and regular feeding—you’ll have vibrant, crunchy capsicums ready to pick.";
                RedirectProduct(R.drawable.capsicum_seeds,name,price,description);
            }
        });

        s_corianders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "Coriander Seeds";
                int price = 499;
                String description = "Coriander seeds contain two seeds within one shell. Gently crushing them before planting helps them split and sprout faster, leading to improved germination.";
                RedirectProduct(R.drawable.coriander_seeds,name,price,description);
            }
        });

        s_fenugreek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "Fenugreek Seeds";
                int price = 499;
                String description = "Fenugreek seeds are tiny powerhouses packed with benefits, including aiding digestion, controlling blood sugar, and enhancing hair and skin health. They are commonly used in various culinary dishes and traditional remedies.";
                RedirectProduct(R.drawable.fenugreek_seeds,name,price,description);
            }
        });

        s_greenchilli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "Green Chilli Seeds";
                int price = 499;
                String description = "Green chilli is one of the easiest and most rewarding plants to grow in a kitchen garden. They can be added to curries, made into spice mixes, or pickled. Green chillies are also a great source of Vitamin A.";
                RedirectProduct(R.drawable.green_chilli_seed,name,price,description);
            }
        });

        s_greencucumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "Green Cucumber Seeds";
                int price = 499;
                String description = "Cucumbers are packed with vitamins and minerals, making them excellent for cooling the body and increasing hydration due to their high water content. The ideal growing medium for cucumber seeds is a mix of two parts garden soil and one part organic manure or a combination of garden soil, coco peat, and vermicompost.";
                RedirectProduct(R.drawable.green_cucumber_seeds,name,price,description);
            }
        });

        s_okras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "Okra Seeds";
                int price = 499;
                String description = "Okra is valued for its high content of magnesium, fiber, antioxidants, and vitamins. Including okra in your diet can promote a feeling of fullness due to its fiber content, improve digestion, and boost immunity through its vital nutrients.";
                RedirectProduct(R.drawable.okra_seeds,name,price,description);
            }
        });

        s_redamaranthus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "Red Amaranth Seeds";
                int price = 499;
                String description = "Red Amaranth is notable for its rapid growth, quick rejuvenation after each harvest, and high yield in a short period. It is highly efficient at photosynthesis and performs well even under adverse environmental conditions.";
                RedirectProduct(R.drawable.red_amaranthus_seeds,name,price,description);
            }
        });

        s_spinch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "Spinch Seeds";
                int price = 499;
                String description = "Spinach seeds yield plants rich in vitamins and minerals, including vitamins A, C, and K, as well as iron, calcium, and potassium.";
                RedirectProduct(R.drawable.spinach_seeds,name,price,description);
            }
        });

        s_tomatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "Tomato Seeds";
                int price = 499;
                String description = "Tomatoes are fragrant, edible berries packed with Vitamin C, fiber, Vitamin A, calcium, and many other important antioxidants.";
                RedirectProduct(R.drawable.tomato_seeds,name,price,description);
            }
        });
        s_amaranths_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.amaranth_seeds,"Amaranth Seeds",499,"Small",1);
        });
        s_beetroots_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.beetroot_seeds,"Beetroot Seeds",99,"Small",1);
        });
        s_broccolis_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.broccoli_seeds,"Broccoli Seeds",129,"Small",1);
        });
        s_capsicums_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.capsicum_seeds,"Capsicum Seeds",99,"Small",1);
        });
        s_corianders_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.coriander_seeds,"Coriander Seeds",99,"Small",1);
        });
        s_fenugreek_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.fenugreek_seeds,"Fenugreek Seed",99,"Small",1);
        });
        s_greenchilli_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.green_chilli_seed,"Green Chilli Seed",99,"Small",1);
        });
        s_greencucumber_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.green_cucumber_seeds,"Green Cucumber Seeds",99,"Small",1);
        });
        s_okras_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.okra_seeds,"Okra Seeds",119,"Small",1);
        });
        s_redamaranthus_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.red_amaranthus_seeds,"Red Amaranthus Seeds",99,"Small",1);
        });
        s_spinch_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.spinach_seeds,"Spinch Seeds",99,"Small",1);
        });
        s_tomatos_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.tomato_seeds,"Tomato Seeds",79,"Small",1);
        });

        ImageView search_icon = findViewById(R.id.search_icon);
        ImageView cart_icon = findViewById(R.id.cart_icon);

        search_icon.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(),search.class);
            startActivity(i);
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        });

        cart_icon.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(),cart.class);
            startActivity(i);
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        });

        String query = getIntent().getStringExtra("query");

        if (query != null && !query.isEmpty()) {
            if (name.contains("Broken Heart Plant") && "Broken Heart Plant".toLowerCase().contains(query.toLowerCase())) h_bhp.setVisibility(View.VISIBLE);
            if (name.contains("Jade Plant Mini") && "Jade Plant Mini".toLowerCase().contains(query.toLowerCase())) h_jmp.setVisibility(View.VISIBLE);
            if (name.contains("Peace Lily Plant") && "Peace Lily Plant".toLowerCase().contains(query.toLowerCase())) h_plp.setVisibility(View.VISIBLE);
            if (name.contains("Ficus Bonsai Plant") && "Ficus Bonsai Plant".toLowerCase().contains(query.toLowerCase())) h_fbp.setVisibility(View.VISIBLE);
            if (name.contains("Lucky Bamboo Plant") && "Lucky Bamboo Plant".toLowerCase().contains(query.toLowerCase())) h_lbp.setVisibility(View.VISIBLE);
            if (name.contains("Stormanthe Triostar Plant") && "Stormanthe Triostar Plant".toLowerCase().contains(query.toLowerCase())) h_stp.setVisibility(View.VISIBLE);
            if (name.contains("Peperomia Green Plant") && "Peperomia Green Plant".toLowerCase().contains(query.toLowerCase())) h_pgp.setVisibility(View.VISIBLE);
            if (name.contains("Money Plant Golden") && "Money Plant Golden".toLowerCase().contains(query.toLowerCase())) h_mpg.setVisibility(View.VISIBLE);
            if (name.contains("Peacock Plant") && "Peacock Plant".toLowerCase().contains(query.toLowerCase())) h_pp.setVisibility(View.VISIBLE);
            if (name.contains("Brazilian Wood Plant") && "Brazilian Wood Plant".toLowerCase().contains(query.toLowerCase())) h_bwp.setVisibility(View.VISIBLE);
            if (name.contains("Aglaonema Red Plant") && "Aglaonema Red Plant".toLowerCase().contains(query.toLowerCase())) h_arp.setVisibility(View.VISIBLE);
            if (name.contains("Aglaonema Pink Beauty Plant") && "Aglaonema Pink Beauty Plant".toLowerCase().contains(query.toLowerCase())) h_apbp.setVisibility(View.VISIBLE);
            if (name.contains("Bamboo Palm XL") && "Bamboo Palm XL".toLowerCase().contains(query.toLowerCase())) h_bpx.setVisibility(View.VISIBLE);
            if (name.contains("Bamboo Palm Plant") && "Bamboo Palm Plant".toLowerCase().contains(query.toLowerCase())) h_bpp.setVisibility(View.VISIBLE);
            if (name.contains("Fiddle Leaf Fig Plant") && "Fiddle Leaf Fig Plant".toLowerCase().contains(query.toLowerCase())) h_flp.setVisibility(View.VISIBLE);
            if (name.contains("Variegated Jade Mini Plant") && "Variegated Jade Mini Plant".toLowerCase().contains(query.toLowerCase())) h_vjmp.setVisibility(View.VISIBLE);

            for (String itemName : name) {
                if (itemName.toLowerCase().contains(query.toLowerCase())) {
                    // match found - make relevant views visible
                    if (itemName.equals("Gradient Wooden Planter")) p_gwp.setVisibility(View.VISIBLE);
                    if (itemName.equals("Orbit Wooden Planter")) p_owp.setVisibility(View.VISIBLE);
                    if (itemName.equals("Ridged Waves Wooden Pot")) p_rwwp.setVisibility(View.VISIBLE);
                    if (itemName.equals("Roma Ceramic Pot")) p_rcp.setVisibility(View.VISIBLE);
                    if (itemName.equals("Cats Are Gods Ceramic Planter")) p_cagcp.setVisibility(View.VISIBLE);
                    if (itemName.equals("Sienna Terracotta Pots")) p_stp.setVisibility(View.VISIBLE);
                    if (itemName.equals("Tulip Fantasy Bowl Ceramic Planter")) p_tfbcp.setVisibility(View.VISIBLE);
                    if (itemName.equals("Tulip Fantasy Flat Ceramic Planter")) p_tffcp.setVisibility(View.VISIBLE);
                    if (itemName.equals("Twilight Clouds Ceramic Planter")) p_tccp.setVisibility(View.VISIBLE);
                    if (itemName.equals("Verona Eco Planter")) p_vep.setVisibility(View.VISIBLE);

                    if (itemName.equals("Dom Metallic Mister")) dmm.setVisibility(View.VISIBLE);
                    if (itemName.equals("Hydra Watering Pitcher")) hwp.setVisibility(View.VISIBLE);
                    if (itemName.equals("Double Prong Weeder")) dpw.setVisibility(View.VISIBLE);
                    if (itemName.equals("Five Prong Weeder")) fpw.setVisibility(View.VISIBLE);
                    if (itemName.equals("Curve Pruning Saw - 33 Cm")) cps.setVisibility(View.VISIBLE);
                    if (itemName.equals("Plastic Impulse Sprinkler")) pis.setVisibility(View.VISIBLE);
                    if (itemName.equals("Sprinkler Stand")) ss.setVisibility(View.VISIBLE);
                    if (itemName.equals("Watermatic Stake")) ws.setVisibility(View.VISIBLE);

                    if (itemName.equals("Amaranth Seeds")) s_amaranths.setVisibility(View.VISIBLE);
                    if (itemName.equals("Beetroot Seeds")) s_beetroots.setVisibility(View.VISIBLE);
                    if (itemName.equals("Broccoli Seeds")) s_broccolis.setVisibility(View.VISIBLE);
                    if (itemName.equals("Capsicum Seeds")) s_capsicums.setVisibility(View.VISIBLE);
                    if (itemName.equals("Coriander Seeds")) s_corianders.setVisibility(View.VISIBLE);
                    if (itemName.equals("Fenugreek Seeds")) s_fenugreek.setVisibility(View.VISIBLE);
                    if (itemName.equals("Green Chilli Seeds")) s_greenchilli.setVisibility(View.VISIBLE);
                    if (itemName.equals("Green Cucumber Seeds")) s_greencucumber.setVisibility(View.VISIBLE);
                    if (itemName.equals("Okra Seeds")) s_okras.setVisibility(View.VISIBLE);
                    if (itemName.equals("Red Amaranthus Seeds")) s_redamaranthus.setVisibility(View.VISIBLE);
                    if (itemName.equals("Spinch Seeds")) s_spinch.setVisibility(View.VISIBLE);
                    if (itemName.equals("Tomato Seed")) s_tomatos.setVisibility(View.VISIBLE);

                }
            }
        }

    }

    public void RedirectProduct(int imageResId,String name, int price, String description){
        Intent intent = new Intent(getApplicationContext(), product.class);
        intent.putExtra("img", imageResId);
        intent.putExtra("name", name);
        intent.putExtra("price", price);
        intent.putExtra("description", description);
        startActivity(intent);
    }

    public boolean onCartClick(int img, String name, int price, String size, int qty) {
        main.performHapticFeedback(HapticFeedbackConstants.CONTEXT_CLICK);
        Intent intent = new Intent(getApplicationContext(), cart.class);
        intent.putExtra("img", img);
        intent.putExtra("name", name);
        intent.putExtra("price", price);
        intent.putExtra("qty", qty);
        intent.putExtra("size", size);
        startActivity(intent);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, R.anim.fade_out);
        finish();
    }

}
