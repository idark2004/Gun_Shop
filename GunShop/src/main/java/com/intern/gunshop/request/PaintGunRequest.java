package com.intern.gunshop.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaintGunRequest {
	
	private int gun_id;
	private int color_id;
	private int quantity;
}
