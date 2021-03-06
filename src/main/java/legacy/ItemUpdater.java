package legacy;

import lombok.AllArgsConstructor;
import lombok.Delegate;

@AllArgsConstructor
public class ItemUpdater {
  @Delegate
  final Item item;

  void updateQuality() {
    if ("Sulfuras, Hand of Ragnaros".equals(getName())) {
      return;
    }

    decreaseSellIn();

    if ("Aged Brie".equals(getName())) {
      increaseQuality();
      if (getSellIn() < 0) increaseQuality();
    } else if ("Backstage passes to a TAFKAL80ETC concert".equals(getName())) {
      increaseQuality();
      if (getSellIn() < 10) increaseQuality();
      if (getSellIn() < 5) increaseQuality();
      if (getSellIn() < 0) setQuality(0);
    } else {
      decreaseQuality();
      if (getSellIn() < 0) decreaseQuality();
    }
  }

  void decreaseSellIn() {
    setSellIn(getSellIn() - 1);
  }

  void decreaseQuality() {
    if (getQuality() > 0) {
      setQuality(getQuality() - 1);
    }
  }

  void increaseQuality() {
    if (getQuality() < 50) {
      setQuality(getQuality() + 1);
    }
  }
}