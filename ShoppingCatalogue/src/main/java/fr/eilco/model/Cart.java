package fr.eilco.model;

import java.util.ArrayList;

import fr.eilco.entities.FacadeProduit;
import fr.eilco.entities.FacadeProduitCommande;

public class Cart{
	private ArrayList<FacadeProduitCommande> cart=new ArrayList<FacadeProduitCommande>();
	
	public Cart() {
		
	}

	public ArrayList<FacadeProduitCommande> getCart() {
		return cart;
	}
	
	public void setCart(ArrayList<FacadeProduitCommande> cart) {
		this.cart = cart;
	}
	
	public void addToCart(FacadeProduitCommande produitCommande) {
		
		if (cart.size()>0) {
			if(cart.stream().filter(o -> o.getProduitID().getNom().equals(produitCommande.getProduitID().getNom())).findFirst().isPresent()) {
				cart.stream().filter(o -> o.getProduitID().getNom().equals(produitCommande.getProduitID().getNom())).findFirst().get().setQuantite(produitCommande.getQuantite());	
			}else {
				cart.add(produitCommande);
			}
			
		}else {
			cart.add(produitCommande);
		}
		
	}
	public double getTotalCartPrice(ArrayList<FacadeProduitCommande> cart) {
        double sum = 0;
        
            if (cart.size() > 0) {
                for (FacadeProduitCommande item : cart) {
           
                        sum+=item.getProduitID().getPrix()*item.getQuantite();
                
                }
            }

        return sum;
    }
	public FacadeProduitCommande getFacadeProduitCommande(ArrayList<FacadeProduitCommande> cart, String nom) {
		FacadeProduitCommande pc=new FacadeProduitCommande();
		if (cart.size()>0) {
			if(cart.stream().filter(o -> o.getProduitID().getNom().equals(nom)).findFirst().isPresent()) {
				pc=cart.stream().filter(o -> o.getProduitID().getNom().equals(nom)).findFirst().get();	
			}
		}
		return pc;
	}
	
	public void removeToCart(String nom) {
		FacadeProduitCommande pc=new FacadeProduitCommande();
		if (cart.size()>0) {
			if(cart.stream().filter(o -> o.getProduitID().getNom().equals(nom)).findFirst().isPresent()) {
				pc= cart.stream().filter(o -> o.getProduitID().getNom().equals(nom)).findFirst().get();	
			
				cart.remove(pc);
			}
			
		}
	}
	public void addQuantiteToProduit(String nom) {
		if (cart.size()>0) {
			if(cart.stream().filter(o -> o.getProduitID().getNom().equals(nom)).findFirst().isPresent()) {
				cart.stream().filter(o -> o.getProduitID().getNom().equals(nom)).findFirst().get().setQuantite(1);	
				
			}
			
		}
	}
	public void reduceQuantiteToProduit(String nom) {
		FacadeProduitCommande pc=new FacadeProduitCommande();
		if (cart.size()>0) {
			if(cart.stream().filter(o -> o.getProduitID().getNom().equals(nom)).findFirst().isPresent()) {
				pc=cart.stream().filter(o -> o.getProduitID().getNom().equals(nom)).findFirst().get();
				if(pc.getQuantite()>0) {
					if(pc.getQuantite()==1) {
						cart.remove(pc);
					}else {
						cart.stream().filter(o -> o.getProduitID().getNom().equals(nom)).findFirst().get().setQuantite(-1);	
					}
					
				}			
			}	
		}
	}
	
}