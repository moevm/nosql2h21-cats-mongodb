interface AnyObject {
    [key: string]: any;
}

export function removeEmptyKeys(object: AnyObject): AnyObject {
  return Object.keys(object).reduce(
    (acc, key) =>
      object[key] ? Object.assign(acc, {[key]: object[key]}) : acc,
    {},
  );
}
