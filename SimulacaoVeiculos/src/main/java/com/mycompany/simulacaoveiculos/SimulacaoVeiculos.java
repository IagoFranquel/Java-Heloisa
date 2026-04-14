package com.mycompany.simulacaoveiculos;

import java.util.Objects;

public class SimulacaoVeiculos {

    public static void main(String[] args) {
        // Criando a pista de testes (nosso simulador)
        SimuladorDeTrafego pista = new SimuladorDeTrafego(5);

        // Criando os veículos para o teste
        Carro meuCarro = new Carro("Ford", "Focus", 4);
        meuCarro.setPlaca("BRA2E19");
        
        Moto minhaMoto = new Moto("Yamaha", "MT-07", 689);
        minhaMoto.setPlaca("KAS-1234");
        
        Caminhao carreta = new Caminhao("Mercedes", "Actros", 15000);
        carreta.setPlaca("ABC-8888");

        System.out.println("=== TESTE DE PISTA INICIADO ===");
        
        pista.estacionar(meuCarro);
        pista.estacionar(minhaMoto);
        pista.estacionar(carreta);

        System.out.println("\n--- Movimentação ---");
        meuCarro.ligar("Esportivo");
        meuCarro.acelerar(); // acelera 10 padrão
        
        minhaMoto.ligar();
        minhaMoto.acelerar(40); // acelera valor específico
        
        // Tentando acelerar o caminhão sem combustível
        carreta.acelerar(); 
        carreta.abastecer(50, "Diesel");
        carreta.acelerar();

        System.out.println("\n--- Status Atual ---");
        pista.exibirStatusDaPista();

        System.out.println("\n--- Interações no Trânsito ---");
        meuCarro.interagir(carreta);
        minhaMoto.interagir(meuCarro);
    }

    // --- CLASSE BASE ---
    static abstract class Veiculo {
        private String marca, modelo, placa;
        private double velocidade;
        protected double tanque = 0; // Começa vazio para testar o erro

        public Veiculo(String marca, String modelo) {
            this.marca = marca;
            this.modelo = modelo;
            this.velocidade = 0;
        }

        public Veiculo(String marca, String modelo, double velocidadeInicial) {
            this(marca, modelo);
            this.velocidade = velocidadeInicial;
        }

        // Getters e Setters básicos
        public String getMarca() { return marca; }
        public String getModelo() { return modelo; }
        public double getVelocidade() { return velocidade; }
        public void setVelocidade(double v) { this.velocidade = v; }
        public String getPlaca() { return placa; }
        public void setPlaca(String p) { this.placa = p; }

        // Lógica de acelerar com verificação de combustível
        public void acelerar() {
            if (tanque > 0) {
                this.velocidade += 10;
                this.tanque -= calcularConsumo();
            } else {
                System.out.println("Aviso: " + modelo + " tentou acelerar mas está sem combustível!");
            }
        }

        public void acelerar(int quanto) {
            if (tanque > 0) {
                this.velocidade += quanto;
                this.tanque -= (calcularConsumo() * 1.2);
            } else {
                System.out.println("Aviso: " + modelo + " não tem combustível para esse pique.");
            }
        }

        public void frear() { this.velocidade -= 10; }

        public void ligar() { System.out.println("Ligando o motor de: " + modelo); }
        public void ligar(String modo) { System.out.println(modelo + " ligado no modo " + modo); }

        public void abastecer(double litros) { this.tanque += litros; }
        public void abastecer(double litros, String tipo) { 
            this.tanque += litros;
            System.out.println(modelo + " abastecido com " + litros + "L de " + tipo);
        }

        public abstract void exibirStatus();
        public abstract double calcularConsumo();

        public void interagir(Veiculo v) {
            System.out.println(this.modelo + " deu sinal de luz para " + v.getModelo());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Veiculo v = (Veiculo) o;
            return Objects.equals(placa, v.placa);
        }

        @Override
        public int hashCode() { return Objects.hash(placa); }
    }

    // --- SUBCLASSES ---
    static class Carro extends Veiculo {
        private int portas;

        public Carro(String marca, String modelo, int portas) {
            super(marca, modelo);
            this.portas = portas;
            this.tanque = 20; // Já vem com um pouco
        }

        @Override
        public void exibirStatus() {
            System.out.println("[CARRO] " + getMarca() + " " + getModelo() + " | Portas: " + portas + " | Vel: " + getVelocidade() + "km/h");
        }

        @Override
        public double calcularConsumo() { return 1.5; }

        @Override
        public String toString() {
            return "Carro: " + getMarca() + " " + getModelo() + " - " + getVelocidade() + "km/h";
        }
    }

    static class Moto extends Veiculo {
        private int cc;

        public Moto(String marca, String modelo, int cc) {
            super(marca, modelo);
            this.cc = cc;
            this.tanque = 10;
        }

        @Override
        public void acelerar() { // Moto é mais ágil
            if (tanque > 0) {
                setVelocidade(getVelocidade() + 15);
                tanque -= calcularConsumo();
            } else {
                System.out.println("Moto " + getModelo() + " no seco!");
            }
        }

        @Override
        public void exibirStatus() {
            System.out.println("[MOTO] " + getMarca() + " " + getModelo() + " | " + cc + "cc | Vel: " + getVelocidade() + "km/h");
        }

        @Override
        public double calcularConsumo() { return 0.8; }
    }

    static class Caminhao extends Veiculo {
        private double pesoCarga;

        public Caminhao(String marca, String modelo, double carga) {
            super(marca, modelo);
            this.pesoCarga = carga;
        }

        @Override
        public void exibirStatus() {
            System.out.println("[CAMINHÃO] " + getMarca() + " " + getModelo() + " | Carga: " + pesoCarga + "kg | Vel: " + getVelocidade() + "km/h");
        }

        @Override
        public double calcularConsumo() { return 6.0; }

        @Override
        public void interagir(Veiculo v) {
            System.out.println("O caminhão " + getModelo() + " buzinou bem alto para " + v.getModelo());
        }
    }

    // --- GERENCIAMENTO ---
    static class SimuladorDeTrafego {
        private Veiculo[] pista;
        private int qtd = 0;

        public SimuladorDeTrafego(int vagas) {
            this.pista = new Veiculo[vagas];
        }

        public void estacionar(Carro c) { adicionar(c); }
        public void estacionar(Moto m) { adicionar(m); }
        public void estacionar(Caminhao cam) { adicionar(cam); }

        private void adicionar(Veiculo v) {
            if (qtd < pista.length) {
                pista[qtd] = v;
                qtd++;
                System.out.println(">>> " + v.getModelo() + " entrou na simulação.");
            } else {
                System.out.println("!!! Pista lotada. " + v.getModelo() + " ficou de fora.");
            }
        }

        public void exibirStatusDaPista() {
            for (int i = 0; i < qtd; i++) {
                pista[i].exibirStatus();
            }
        }
    }
}