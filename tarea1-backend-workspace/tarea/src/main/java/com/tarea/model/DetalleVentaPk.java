package com.tarea.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class DetalleVentaPk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDetalleVenta;

	@ManyToOne
	@JoinColumn(name = "id_venta", nullable = false)
	private Venta venta;

	@ManyToOne
	@JoinColumn(name = "id_producto", nullable = false)
	private Producto producto;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDetalleVenta == null) ? 0 : idDetalleVenta.hashCode());
		result = prime * result + ((producto == null) ? 0 : producto.hashCode());
		result = prime * result + ((venta == null) ? 0 : venta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetalleVentaPk other = (DetalleVentaPk) obj;
		if (idDetalleVenta == null) {
			if (other.idDetalleVenta != null)
				return false;
		} else if (!idDetalleVenta.equals(other.idDetalleVenta))
			return false;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		if (venta == null) {
			if (other.venta != null)
				return false;
		} else if (!venta.equals(other.venta))
			return false;
		return true;
	}

	
}
