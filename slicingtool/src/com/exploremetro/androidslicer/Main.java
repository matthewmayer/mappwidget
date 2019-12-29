/*************************************************************************
* Copyright (c) 2015 Lemberg Solutions
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
**************************************************************************/

package com.exploremetro.androidslicer;

import java.io.File;



import com.exploremetro.androidslicer.cutter.Cutter;
import com.exploremetro.androidslicer.cutter.OnCompliteListener;
import com.exploremetro.androidslicer.cutter.OnProgressUpdateListener;


public class Main 
{
	
	
	public static void main(String[] args) {
		final Cutter cutter = new Cutter(new OnProgressUpdateListener()
		{
			@Override
			public void onProgressUpdate(int value)
			{
				System.out.println("Progress "+value);
			}
		}, new OnCompliteListener()
		{

			@Override
			public void onComplite()
			{
				System.out.println("Complete");
			}
		});
		String imgPath = args[0];
		String dir = args[1];
		String name = args[2];
		int tileSize = 256;

		
		File f = new File(imgPath);

		if (f.exists())
		{
			cutter.startCuttingAndroid(imgPath, dir, name, tileSize);
		}
		else
		{
			System.out.println("image not found at "+imgPath);
			return;
		}

	}
}